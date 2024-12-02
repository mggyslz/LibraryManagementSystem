# LibraryManagementSystem
## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
---

## Project Description
The Library Management System is a Java-based program made to effectively manage the books and student profiles in a library. Users can create reports, manage students, borrow books, add books, and save data to a file. The system guarantees library management activities run smoothly and are easy to access.

---

## Features
1. **Add Students and Books**
   - Supports both E-Books and Physical Books.
2. **Borrow Books**
   - Allows students to borrow books, with tracking.
3. **List Records**
   - View all books and students in the system.
4. **Generate Reports**
   - Overview of total books, borrowed books, and registered students.
5. **Save Data**
   - Stores all books, students, and borrowing records to a file (`library_data.txt`).
6. **Update Records**
   - Edit student and book details.

---

## Technologies Used
- **Programming Language**: Java
- **Libraries**: 
  - `java.util` for data structures like `ArrayList`.
  - `java.io` for file handling.
  - `java.util` for user input like `Scanner`.
- **Development Environment**: `Vs Code` and `Apache NetBeans IDE 22` 

---


## Usage
1. **Run the Application**:
   - Launch the program either from the IDE or command line.
2. **Navigate through the Menu**:
   - Use the displayed menu to perform operations:
     - Add Books or Students.
     - Borrow Books.
     - List all Books or Students.
     - Generate Reports.
     - Update books or Students.
     - Save data to a file.
3. **Data Persistence**:
   - All data can be saved to `library_data.txt`.

---

### **Adding a Book**
1. Choose the "Add Book" option.
2. Input book details (title, author, ISBN, and file size/page count).
3. The system confirms the book is added.

### **Borrowing a Book**
1. Select the "Borrow Book" option.
2. Enter the student's ID and the book's title.
3. The system records the borrowing and marks the book as borrowed.

### **List All Books or Students**
 **Books**
1. Displays each book's title, author, ISBN, and whether it is currently borrowed.
2. Includes both E-Books and Physical Books.
**Students**
1. Displays each student's name and ID.

### **Update Books or Students**
 **Books**
1. Change the name of the book.
2. Update the author's information.
3. Fix or change the book's unique identifier.
4. Mark a book as borrowed or available.
 **Students**
1. Correct or update the student's name.
2. Modify the student's ID if there are changes or errors.

### **Save Data to a File**
 **Books**
1. Saves data such as Title, Author, ISBN, and Borrowed Status.
 **Students**
2. Saves data such as Name, ID, and their borrowing history:
    -Acts as a backup of the library data.
    -Allows librarians to review records outside the system.
    -Facilitates data sharing or auditing.

---

## Contact
For questions or collaboration:
- Name: Gil IV Miguel Salvador I. Cea
- Email: miggymiggyimperialcea@gmail.com
- GitHub: [mggyslz](https://github.com/mggyslz)
 
