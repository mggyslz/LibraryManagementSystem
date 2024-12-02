abstract class Book {
    // Attributes
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed; 
    // Constructor to initialize the book's details
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false; 
    }
    // Getter and Setter method
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; } 
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; } 
    
    // Abstract method to display book details
    // This must be implemented by any subclass of Book
    public abstract void displayDetails();
    
     
}
