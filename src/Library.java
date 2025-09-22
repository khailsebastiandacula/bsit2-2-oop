public class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        books = new Book[10];
        bookCount = 0;
    }

    public boolean addBook(Book book) {
        if (bookCount >= books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return false;
        }
        books[bookCount++] = book;
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
        return true;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                return true;
            }
        }
        return false;
    }

    public Book findBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null && book.borrowBook()) {
            System.out.println("Book borrowed successfully!");
            return true;
        }
        System.out.println("Book is not available for borrowing.");
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null && book.returnBook()) {
            System.out.println("Book returned successfully!");
            return true;
        }
        System.out.println("Book was not borrowed.");
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("\nAvailable books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                books[i].printBookInfo();
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("\nAll books in library:");
        for (int i = 0; i < bookCount; i++) {
            books[i].printBookInfo();
        }
    }

    public int getBookCount() {
        return bookCount;
    }
}
