import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
      LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println(
            "*********************Welcome to the M.A.M Library!********************");
        System.out.println(
            "                     A Library Management System!                      ");
        System.out.println(
            "                   Select From The Following Options:               ");
        System.out.println(
            "***********************************************************************");
            
            System.out.println("---------------------------------------------");
            System.out.println("  1. Add Book");
            System.out.println("  2. Add Student");
            System.out.println("  3. Borrow Book");
            System.out.println("  4. List All Books");
            System.out.println("  5. List All Students");
            System.out.println("  6. Generate Reports");
            System.out.println("  7. Update Students");
            System.out.println("  8. Update Books");
            System.out.println("  9. Delete Data");
            System.out.println("  10. Display Student Borrowing Records");
            System.out.println("  11. Save Library Data to File and Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            // swtich Statement for Choosing the options above
            switch (choice) {
                case 1 : library.addBook();
                 break;
                case 2 : library.addStudent();
                 break;
                case 3 : library.borrowBook();
                 break;
                case 4 : library.listAllBooks();
                 break;
                case 5 : library.listAllStudents();
                 break;
                case 6 : library.generateReport();
                 break;
                case 7: library.updateStudent();
                 break;
                case 8: library.updateBook();
                 break;
                 case 9: library.deleteEntity();
                 break;
                case 10 : {
                    System.out.print("Enter student ID to view records: ");
                    String studentID = scanner.nextLine();
                    for (StudentProfile student : library.students) {
                        if (student.getStudentID().equalsIgnoreCase(studentID)) {
                            student.displayBorrowingRecords();
                            break;
                        }
                    }
                }
                 case 11: {
                     System.out.println("Saving data to file...");
                     library.saveDataToFile(); // Save data when exiting
                     System.out.println("Exiting the Library Management System. Goodbye!");
                     scanner.close();
                     return;
                }
                default : System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
