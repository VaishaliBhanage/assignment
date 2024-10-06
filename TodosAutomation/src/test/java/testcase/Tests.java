package testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LaunchPage;

public class Tests extends BaseClass{

	//Testcase No 1: Add tasks
	@Test(dataProvider = "tasks")
	public static void addTasks(String str) throws Exception {
		
		System.out.println(str);
		 LaunchPage lp = new LaunchPage(driver); 
		 lp.enterToDo(str);
		 lp.validateAddedTask(str,true);
		 Thread.sleep(2000);
	}
	
	//Testcase No 2: Mark as Complete task
	//@Parameters("completedTask")
	@Test (dependsOnMethods = "addTasks")
	public static void markAsCompleteTasks() {
		
		String completedTask= prop.getProperty("completedTask");
		
		LaunchPage lp = new LaunchPage(driver);
		
		try {
			lp.markCompleteTask(completedTask);
			Thread.sleep(2000);
			
		}catch (Exception e) {
			System.out.println("Exception found: "+e.getMessage());
		}
		
	}
	
	//Testcase No.3 : Delete Task
	
	@Test (dependsOnMethods = "addTasks")
	public static void deleteTask() throws IOException {
		
		String deleteTask= prop.getProperty("deletetask");
		
		LaunchPage lp = new LaunchPage(driver);
		
		try {
			lp.deleteTask(deleteTask);
			Thread.sleep(2000);
			
		}catch (Exception e) {
			System.out.println("Exception found: "+e.getMessage());
		}

	}
	
	//Testcase No. 4: Filter all Active Todo tasks
	@Test (dependsOnMethods = "markAsCompleteTasks")
	public static void filterActiveTab() {
		
		String completedTask= prop.getProperty("completedTask");
		LaunchPage lp = new LaunchPage(driver);
		lp.clickActiveTab();
		List<String> activeList=lp.listofTask();
		//Validating completed task is not displaying in active tab
		assertEquals(activeList.contains(completedTask), false);		
	}
	
	//Testcase No. 5: Filter all Completed tasks
		@Test (dependsOnMethods = "markAsCompleteTasks")
		public static void filterCompletedTab() {
			
			String activetask= prop.getProperty("activetask");
			LaunchPage lp = new LaunchPage(driver);
			lp.clickCompletedTab();
			List<String> completeTasklist=lp.listofTask();
			//Validating active task is not displaying in active tab
			assertEquals(completeTasklist.contains(activetask), false);		
		}
	
	//Testcase No.6: Add an Empty Todo task
	@Test
	public static void addEmptyTask() {
		LaunchPage lp = new  LaunchPage(driver);
		try {
			lp.validateAddedTask("",false);
			lp.validateEmptyValueNotAdded("");
		}catch(Exception e) {
			System.out.println("Exception found: "+e.getMessage());
		}
	}
	
	//Testcase No.7: Add a Todo Task with Only Spaces
     @Test
		public static void addTaskWithSpace() {
			LaunchPage lp = new  LaunchPage(driver);
			try {
				lp.validateAddedTask("  ",false);
				lp.validateEmptyValueNotAdded("  ");
			}catch(Exception e) {
				System.out.println("Exception found: "+e.getMessage());
			}
		}
		
      //Testcase No. 8: Clear all Completed tasks
   		@Test (dependsOnMethods = "filterActiveTab")
   		public static void clearCompletedTask() {
   			LaunchPage lp = new LaunchPage(driver);
   			lp.clickClearCompleted();
   			lp.clickCompletedTab();
   			List<String> completedTaskList=lp.listofTask();
   			//Validating active task is not displaying in active tab 
   			assertEquals(completedTaskList.size(), 0);		
   		}

}
