class PhysicalBook extends Book {
    private int pageCount;

    public PhysicalBook(String title, String author, String isbn, int pageCount) {
        super(title, author, isbn);
        this.pageCount = pageCount;
    }
  public int getPageCount() { return pageCount; }
    @Override
    public void displayDetails() {
        System.out.println( getTitle());
        System.out.println( getAuthor());
        System.out.println( getIsbn());
        System.out.println( pageCount);
        System.out.println( (isBorrowed() ? "Yes" : "No"));
    }
}