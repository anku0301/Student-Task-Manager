# Student Task Manager

A simple command-line Student Task Manager built with Java and Object-Oriented Programming principles.

## Features

- Add new student tasks
- View all tasks
- Mark tasks as completed
- Delete tasks
- Automatically save tasks to a file
- Load saved tasks when the application starts
- Input validation for task numbers

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- File I/O
- Java Serialization
- VS Code

## Project Structure

```text
Student-Task-Manager/
├── src/
│   ├── Main.java
│   └── Task.java
├── .gitignore
└── README.md
```

## How to Run

Make sure Java JDK 17 or newer is installed.

### Compile

```bash
javac -d out src/*.java
```

### Run

```bash
java -cp out Main
```

## Example

```text
=================================
      STUDENT TASK MANAGER
=================================

1. Add Task
2. View Tasks
3. Mark Task as Completed
4. Delete Task
5. Exit
Choose an option:
```

## What I Learned

This project demonstrates:

- Creating and using Java classes
- Encapsulation with private fields and getters/setters
- Working with `ArrayList`
- Handling user input with `Scanner`
- Exception handling
- Reading and writing files
- Object serialization
- Building a simple menu-driven application

## Future Improvements

Possible future features include:

- Task due dates
- Task priorities
- Search and filter
- A graphical user interface
- Database storage
- User accounts

## Author

Ankush Jagtap
