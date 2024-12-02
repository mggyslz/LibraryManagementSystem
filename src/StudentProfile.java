import java.util.ArrayList;
import java.util.List;

class StudentProfile {
    private String studentName;
    private String studentID;
    private List<BorrowingRecord> borrowingRecords;
    //Contructors
    public StudentProfile(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.borrowingRecords = new ArrayList<>();
    }

    public String getStudentName() { return studentName; }
    public String getStudentID() { return studentID; }
    public List<BorrowingRecord> getBorrowingRecords() { return borrowingRecords; }

    // Method to add a borrowing record
    public void addBorrowingRecord(BorrowingRecord record) {
        borrowingRecords.add(record);
    }

    // Method to display borrowing records
    public void displayBorrowingRecords() {
        if (borrowingRecords.isEmpty()) {
            System.out.println("No borrowing records for " + studentName);
        } else {
            System.out.println("Borrowing records for " + studentName + ":");
            for (BorrowingRecord record : borrowingRecords) {
                System.out.println("- Book: " + record.getBookTitle() + ", Borrowed on: " + record.getBorrowDate() +
                                   ", Returned on: " + (record.getReturnDate() == null ? "Not returned" : record.getReturnDate()));
            }
        }
    }
}
