# assignment
Assignment of todos task website
Selenium Automation Project:
This project automates the testing of a Todo application using Selenium WebDriver with Java, TestNG, Page Object Model (POM), and Data Provider.

Prerequisites:
Java JDK 8 or higher
Maven
TestNG
Selenium WebDriver
IDE (e.g., IntelliJ IDEA, Eclipse)

Project Structure:
src/main/java: Contains the Page Object Model classes.
src/test/java: Contains the TestNG test classes.
src/test/resources: Contains test data files.

Scenarios Covered
1. Add a Todo Item
Steps:
Enter a new todo item in the input field.
Press Enter.
Expected Result:
The new todo item should appear in the list below the input field.
2. Mark a Todo Item as Completed
Steps:
Click the checkbox next to a todo item.
Expected Result:
The todo item should be marked as completed, typically shown with a strikethrough.
3. Delete a Todo Item
Steps:
Click the “X” button next to a todo item.
Expected Result:
The todo item should be removed from the list.
4. Filter Active Todo Items
Steps:
Add multiple todo items.
Mark some as completed.
Click the “Active” filter.
Expected Result:
Only the active (not completed) todo items should be displayed.
5. Filter Completed Todo Items
Steps:
Add multiple todo items.
Mark some as completed.
Click the “Completed” filter.
Expected Result:
Only the completed todo items should be displayed.
6. Clear Completed Todo Items
Steps:
Add multiple todo items.
Mark some as completed.
Click the “Clear completed” button.
Expected Result:
All completed todo items should be removed from the list.
7. Add an Empty Todo Item
Steps:
Press Enter without typing anything in the input field.
Expected Result:
No new todo item should be added to the list.
8. Add a Todo Item with Only Spaces
Steps:
Enter spaces in the input field.
Press Enter.
Expected Result:
No new todo item should be added to the list.
Running the Tests
Clone the repository.
Navigate to the project directory.
Run the tests using TestNG from your IDE or using Maven:
mvn test
 
 
