import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

    public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();
    public List<StudentProfile> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public LibraryManagementSystem() {
        books.add(new EBook("Digital Fortress", "Dan Brown", "9780312944927", "5MB"));
        books.add(new PhysicalBook("To Kill a Mockingbird", "Harper Lee", "9780060935467", 324));
        books.add(new PhysicalBook("1984", "George Orwell", "9780451524935", 328));
        books.add(new PhysicalBook("Harry Potter", "J.K. Rowling", "9780677524935", 703));
        books.add(new EBook("A Separate Peace", "John Knowles", "97804578824935", "7MB"));
        books.add(new PhysicalBook("48 Laws Of Power", "Robert Greene", "9780788524935", 345));

        students.add(new StudentProfile("Aldrich Francisco", "S001"));
        students.add(new StudentProfile("Mark Baltazar", "S002"));
        students.add(new StudentProfile("Miggz Cea", "S003"));
        students.add(new StudentProfile("Lebron James", "S004"));
        students.add(new StudentProfile("Winnie The Pooh", "S005"));
        students.add(new StudentProfile("Peter Parker", "S006"));
    }

    public void addStudent() {
        System.out.print("Enter student name   : ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID     : ");
        String id = scanner.nextLine();
       
        students.add(new StudentProfile(name, id));
        System.out.println("Student added successfully!");
    }
    public void updateStudent() {
    System.out.print("Enter the student ID to update: ");
    String studentID = scanner.nextLine();

    // Find the student by ID
    StudentProfile studentToUpdate = null;
    for (StudentProfile student : students) {
        if (student.getStudentID().equalsIgnoreCase(studentID)) {
            studentToUpdate = student;
            break;
        }
    }

    if (studentToUpdate == null) {
        System.out.println("Student not found.");
        return;
    }

    System.out.print("Enter new name for the student (leave blank to keep current name): ");
    String newName = scanner.nextLine();
    if (!newName.isBlank()) {
        studentToUpdate.setStudentName(newName); 
    }

    System.out.print("Enter new ID for the student (leave blank to keep current ID): ");
    String newID = scanner.nextLine();
    if (!newID.isBlank()) {
        studentToUpdate.setStudentID(newID);
    }

    System.out.println("Student updated successfully!");
}

    public void addBook() {
        System.out.println("Choose book type to add: 1. E-Book 2. Physical Book");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter title   : ");
        String title = scanner.nextLine();
        System.out.print("Enter author  : ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN    : ");
        String isbn = scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter file size (e.g., 2MB) : ");
            String fileSize = scanner.nextLine();
            books.add(new EBook(title, author, isbn, fileSize));
        } else if (choice == 2) {
            System.out.print("Enter page count   : ");
            int pageCount = scanner.nextInt();
            books.add(new PhysicalBook(title, author, isbn, pageCount));
        }
        System.out.println("Book added successfully!");
    }
    
    public void updateBook() {
    System.out.print("Enter the title of the book to update: ");
    String bookTitle = scanner.nextLine();


    Book bookToUpdate = null;
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(bookTitle)) {
            bookToUpdate = book;
            break;
        }
    }

    if (bookToUpdate == null) {
        System.out.println("Book not found.");
        return;
    }

 
    System.out.print("Enter new title for the book (leave blank to keep current title): ");
    String newTitle = scanner.nextLine();
    if (!newTitle.isBlank()) {
        bookToUpdate.setTitle(newTitle);
    }

    System.out.print("Enter new author for the book (leave blank to keep current author): ");
    String newAuthor = scanner.nextLine();
    if (!newAuthor.isBlank()) {
        bookToUpdate.setAuthor(newAuthor); 
    }

    System.out.print("Is the book borrowed? (yes/no, leave blank to keep current status): ");
    String isBorrowed = scanner.nextLine();
    if (!isBorrowed.isBlank()) {
        bookToUpdate.setBorrowed(isBorrowed.equalsIgnoreCase("yes"));
    }

    System.out.println("Book updated successfully!");
}


    public void borrowBook() {
        System.out.print("Enter student ID   : ");
        scanner.nextLine();
        String studentID = scanner.nextLine();

        StudentProfile student = null;
        for (StudentProfile s : students) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();

        // Find the book
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book not available for borrowing.");
            return;
        }

        System.out.print("Enter borrow date (e.g., YYYY-MM-DD)  : ");
        String borrowDate = scanner.nextLine();
        
        bookToBorrow.setBorrowed(true);
        BorrowingRecord record = new BorrowingRecord(title, borrowDate, null);
        student.addBorrowingRecord(record);
        System.out.println("Book borrowed successfully!");
    }
      public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Listing all books:");
        for (Book book : books) {
           /*System.out.println("-------------------------------");
           System.out.println("Title    : " + book.getTitle());
           System.out.println("Author   : " + book.getAuthor());
           System.out.println("Borrowed : " + (book.isBorrowed() ? "Yes" : "No"));
           System.out.println("-------------------------------");*/
           
            //comment cuz i cant choose between the two.
           System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Borrowed: " + (book.isBorrowed() ? "Yes" : "No") + ")");
        }
        
    }
    public void listAllStudents() {
      if (students.isEmpty()) {
        System.out.println("No students in the system.");
        return;
      }
       System.out.println("Listing all students:");
        for (StudentProfile student : students) {
        System.out.println("- " + student.getStudentName() + " (ID: " + student.getStudentID() + ")");
     }
   }
      
    public void generateReport() {
     int totalBooks = books.size();
     int totalBorrowedBooks = (int) books.stream().filter(Book::isBorrowed).count();
     int totalStudents = students.size();
      System.out.println("Library Report:");
      System.out.println("Total Books          : " + totalBooks);
      System.out.println("Total Borrowed Books : " + totalBorrowedBooks);
      System.out.println("Total Students       : " + totalStudents);
    }
      
    public void deleteEntity() {
     System.out.println("What would you like to delete?");
     System.out.println("1. Student");
     System.out.println("2. Book");
     System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
       scanner.nextLine(); 
        switch (choice) {
            case 1 : {
                System.out.print("Enter the ID of the student to delete: ");
                String studentID = scanner.nextLine();
                StudentProfile studentToRemove = null;
                for (StudentProfile student : students) {
                    if (student.getStudentID().equalsIgnoreCase(studentID)) {
                        studentToRemove = student;
                        break;
                    }
                }       if (studentToRemove != null) {
                    students.remove(studentToRemove);
                    System.out.println("Student with ID " + studentID + " has been deleted successfully.");
                } else {
                    System.out.println("No student found with ID " + studentID + ".");
                }
            }
            case 2 : {
                System.out.print("Enter the title of the book to delete: ");
                String bookTitle = scanner.nextLine();
                Book bookToRemove = null;
                for (Book book : books) {
                    if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                        bookToRemove = book;
                        break;
                    }
                }       if (bookToRemove != null) {
                    if (bookToRemove.isBorrowed()) {
                        System.out.println("Cannot delete a borrowed book.");
                    } else {
                        books.remove(bookToRemove);
                        System.out.println("Book with title \"" + bookTitle + "\" has been deleted successfully.");
                    }
                } else {
                    System.out.println("No book found with title \"" + bookTitle + "\".");
                }
            }
            default : System.out.println("Invalid choice. Please select 1 for Student or 2 for Book.");
        }
}
        
    public void saveDataToFile() {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("library_data.txt"))) {

            // Write books to file
            writer.write("Books:\n");
            for (Book book : books) {
                writer.write("Title: " + book.getTitle() + "\n");
                writer.write("Author: " + book.getAuthor() + "\n");
                writer.write("ISBN: " + book.getIsbn() + "\n");
                writer.write("Borrowed: " + (book.isBorrowed() ? "Yes" : "No") + "\n");
                writer.write("--------------\n");
            }
            writer.write("\nStudents:\n");
            for (StudentProfile student : students) {
                writer.write("Name: " + student.getStudentName() + "\n");
                writer.write("ID: " + student.getStudentID() + "\n");

                writer.write("Borrowing Records:\n");
                for (BorrowingRecord record : student.getBorrowingRecords()) {
                    writer.write("Book: " + record.getBookTitle() + ", Borrowed on: " + record.getBorrowDate() +
                            ", Returned on: " + (record.getReturnDate() == null ? "Not returned" : record.getReturnDate()) + "\n");
                }
                writer.write("--------------\n");
            }

            System.out.println("Data saved to library_data.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }
}
