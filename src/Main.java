public class Main {
    public static void main(String[] args) {
        System.out.println("==== LIBRARY MANAGEMENT SYSTEM TEST ===");

        System.out.println("\n === Adding Items to Library ===");
        Book book = new Book("B1", "Java Programming", "James Gosling", "ISBN001", 350, "Programming");
        Magazine magazine = new Magazine("M1", "Tech Today", "Editor Smith", 23, "October", true);
        DVD dvd = new DVD("D1", "The Matrix", "Wachowski Sisters", 136, "R", "Sci-Fi");

        LibraryManager manager = new LibraryManager();
        manager.addItem(book);
        System.out.println("Added: Book - " + book.title + " by " + book.author);
        manager.addItem(magazine);
        System.out.println("Added: Magazine - " + magazine.title + " by " + magazine.author);
        manager.addItem(dvd);
        System.out.println("Added: DVD - " + dvd.title + " by " + dvd.author);

        System.out.println("\n=== Displaying All Items ===");
        for (Borrowable item : manager.getItems()) {
            LibraryItem libItem = (LibraryItem) item;
            String type = libItem.getItemType();
            System.out.println(type + ": " + libItem.title + " (" + item.getBorrowingStatus() + ")");
        }

        System.out.println("\n=== Testing Borrowing ===");
        Student student = new Student("S1", "John Smith", "john@example.com", "STU123", "Computer Science");
        Faculty faculty = new Faculty("F1", "Dr. Smith", "smith@example.com", "Engineering", "Professor");


        book.borrowItem(student.getName());
        student.addBorrowedItem(book);
        System.out.println("Student " + student.getName() + " borrowed: " + book.title);

        dvd.borrowItem(faculty.getName());
        faculty.addBorrowedItem(dvd);
        System.out.println("Faculty " + faculty.getName() + " borrowed: " + dvd.title);

        System.out.println("\n=== Displaying Available Items ===");
        for (Borrowable item : manager.getItems()) {
            if (item.isAvailable()) {
                LibraryItem libItem = (LibraryItem) item;
                System.out.println(libItem.getItemType() + ": " + libItem.title + " (" + item.getBorrowingStatus() + ")");
            }
        }

        System.out.println("\n=== Testing Late Fees ===");
        System.out.printf("%s - 5 days late: $%.2f\n", book.title, book.calculateLateFee(5));
        System.out.printf("%s - 3 days late: $%.2f\n", dvd.title, dvd.calculateLateFee(3));

        System.out.println("\n=== Testing User Information ===");
        System.out.println("Student: " + student.getName() + " (" + student.getMajor() + ") - " + student.getBorrowedItemsCount() + " items borrowed");
        System.out.println("Faculty: " + faculty.getName() + " (" + faculty.getDepartment() + ") - " + faculty.getBorrowedItemsCount() + " items borrowed");
    }
}
