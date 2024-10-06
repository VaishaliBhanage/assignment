package pages;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BaseClass;

public class LaunchPage{
	
	//private By newToDo=By.xpath("//input[@id='todo-input']");
	WebDriver driver;
	
	public LaunchPage(WebDriver driver1) {
		this.driver= driver1;
	}
	int seqNum;
	
	private By todoInput = By.xpath("//input[@id='todo-input']");
	private By lefttask = By.xpath("//footer/span[@class='todo-count']");
	private By allTab = By.xpath("//footer/ul/li/a[text()='All']");
	private By activeTab = By.xpath("//footer/ul/li/a[text()='Active']");
	private By completedTab = By.xpath("//footer/ul/li/a[text()='Completed']");
	private By clearCompltedbtn = By.xpath("//button[@class='clear-completed']");
	private By activeTaskList = By.xpath("//label[@data-testid='todo-item-label']");

	public void enterToDo(String task) {
		WebElement task3= driver.findElement(todoInput);
		task3.click();
		task3.sendKeys(task);
		task3.sendKeys(Keys.ENTER);
	}
	
	public void validateAddedTask(String task,boolean isAdded) {
		WebElement taskElement= driver.findElement(By.xpath("//label[text()='"+task+"']"));
		System.out.println("Added Task: "+task);
		if(isAdded) {
		assertEquals(true, taskElement.isDisplayed());
		}
	}
	
	public void validateLeftTask() {
		assertEquals(true, driver.findElement(lefttask));
		
	}
	
	public void clickAllTab() {
		WebElement task = driver.findElement(allTab);
		assertEquals(true, task);
		task.click();
		
	}
	
	public void clickActiveTab() {
		WebElement task = driver.findElement(activeTab);
		assertEquals(true, task.isDisplayed());
		System.out.println("Clicking on Active tab..");
		task.click();
	}
	
	public void markCompleteTask(String completedTask) {
		driver.findElement(By.xpath("//label[text()='"+completedTask+"']//preceding-sibling::input[@type='checkbox']")).click();
	}
	
	public void clickCompletedTab() {
		WebElement task = driver.findElement(completedTab);
		assertEquals(true, task.isDisplayed());
		task.click();
		
	}
	
	public void clickClearCompleted() {
		WebElement task = driver.findElement(clearCompltedbtn);
		assertEquals(true, task.isDisplayed());
		task.click();
		
	}
	
	public List<String> listofTask(){
		List<WebElement> allActiveTasks=driver.findElements(activeTaskList);
		List<String> allActiveTaskText = new ArrayList<>();
		for(WebElement e : allActiveTasks) {
			System.out.println(e.getText());
			allActiveTaskText.add(e.getText());
		}
		return allActiveTaskText;	
	}
	
	public void deleteTask(String deletetask) {
		driver.findElement(By.xpath("//label[text()='"+deletetask+"']")).click();
		System.out.println("Task deleted:" + deletetask);
		driver.findElement(By.xpath("(//label[text()='"+deletetask+"']//following::button[@class= 'destroy'])[1]")).click();
	}
	
	public void validateEmptyValueNotAdded(String task) {
		List<WebElement> taskElement= driver.findElements(By.xpath("//input[@data-testid='todo-task-toggle']//following::label[text()='"+task+"']"));
		System.out.println("Added Task: "+task);
		assertEquals(0, taskElement.size());
		
	}
	

}
