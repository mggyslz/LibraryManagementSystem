class EBook extends Book {
    private String fileSize;
   //Constructor
    public EBook(String title, String author, String isbn, String fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }
  public String getFileSize() { return fileSize; }
 
    public void displayDetails() {   
        System.out.println( getTitle());
        System.out.println( getAuthor());
        System.out.println( getIsbn());
        System.out.println( fileSize);
        System.out.println( (isBorrowed() ? "Yes" : "No"));    
    }
}

