# Student Grade Tracker

A console-based Java application for entering, storing, and analyzing student grades. This project was created as Task 1 for the CodeAlpha Internship.

## Features

- Add multiple students with their names and marks
- Store student data using `ArrayList`
- Enter multiple marks for every student
- Validate marks between 0 and 100
- Calculate each student's:
  - Average score
  - Highest score
  - Lowest score
- View all student records with marks and statistics
- Generate a summary report containing:
  - Per-student average, highest, and lowest marks
  - Overall class average
  - Overall class highest and lowest marks
- Handle invalid menu choices and invalid mark input

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList / List
- Scanner for console input

## Project Structure

```text
CodeAlpha_StudentGradeTracker/
└── src/
    └── com/
        └── codealpha/
            └── gradetracker/
                ├── Main.java
                └── Student.java
```

## How to Run

1. Clone or download this repository.
2. Open the project in VS Code, Eclipse, IntelliJ IDEA, or another Java IDE.
3. Open:

   ```text
   src/com/codealpha/gradetracker/Main.java
   ```

4. Run the `Main` class.
5. Use the console menu to add students, enter marks, view student records, and generate a summary report.

## Menu Options

```text
1. Add a new student and their marks
2. View all students with their marks and statistics
3. View summary report
4. Exit
```

## Sample Input

```text
Student name: Abhijeet
Marks: 85, 90, 78
```

## Sample Output

```text
Abhijeet             Avg: 84.33 Highest: 90   Lowest: 78

Class Average: 84.33
Class Highest: 90
Class Lowest: 78
```

## Internship

**Organization:** CodeAlpha  
**Task:** Student Grade Tracker  
**Domain:** Java Programming  

## Author

Abhijeet Mole  
B.Tech Computer Science Student | Pune, Maharashtra
