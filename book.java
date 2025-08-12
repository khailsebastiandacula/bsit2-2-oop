public class Book {
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;


    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
        System.out.println("A new book '" + title + "' by " + author + " has been added to the library!");
    }


    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println();
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed '" + title + "'. Enjoy reading!");
        } else {
            System.out.println("Sorry, '" + title + "' is currently not available.");
        }
    }
