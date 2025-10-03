import java.util.ArrayList;

public class LibraryManager {
    private ArrayList<Borrowable> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
    }

    public void displayAllItems() {
        for (Borrowable item : items) {
            System.out.println(((LibraryItem) item).getItemInfo() + " | " + item.getBorrowingStatus());
        }
    }

    public void displayAvailableItems() {
        for (Borrowable item : items) {
            if (item.isAvailable()) {
                System.out.println(((LibraryItem) item).getItemInfo());
            }
        }
    }

    public void borrowItem(String itemId, String borrowerName) {
        for (Borrowable item : items) {
            if (((LibraryItem) item).itemId.equals(itemId) && item.isAvailable()) {
                item.borrowItem(borrowerName);
                System.out.println("Item " + itemId + " borrowed by " + borrowerName);
                return;
            }
        }
        System.out.println("Item not found or already borrowed.");
    }

    public void returnItem(String itemId) {
        for (Borrowable item : items) {
            if (((LibraryItem) item).itemId.equals(itemId) && !item.isAvailable()) {
                item.returnItem();
                System.out.println("Item " + itemId + " returned.");
                return;
            }
        }
        System.out.println("Item not found or not currently borrowed.");
    }

    public double calculateTotalLateFees(int daysLate) {
        double total = 0.0;
        for (Borrowable item : items) {
            total += ((LibraryItem) item).calculateLateFee(daysLate);
        }
        return total;
    }
    public ArrayList<Borrowable> getItems() {
        return items;
    }

}
