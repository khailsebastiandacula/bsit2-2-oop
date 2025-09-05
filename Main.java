public class Main {
    public static void main(String[] args) {
        System.out.println("Food Ordering System");

        Order order1 = new Order("Alice Johnson");
        Order order2 = new Order("Bob Smith");
        Order order3 = new Order("Charlie Brown");

        System.out.println("Creating orders and adding items...");

        try {
            order1.addItem("Pizza", 12.99);
            System.out.println("Item 'Pizza' added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order2.addMultipleItems(new String[]{"Burger", "Fries"}, new double[]{8.50, 3.25});
            System.out.println("Items added: Burger, Fries");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addItem("Soda", -5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addItem("", 4.50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order3.addMultipleItems(new String[]{"Pizza", "Pasta"}, new double[]{10.99, 9.99});
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nOrder Results:");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

        System.out.println("\nTotal orders created: " + Order.getTotalOrders());

        Order highestOrder = findHighestTotalOrder(order1, order2, order3);
        System.out.println("Largest order: " + highestOrder.getCustomerName() + " ($" + highestOrder.getTotalAmount() + ")");

        System.out.println("Items in this order: ");
        for (int i = 0; i < highestOrder.getItemCount(); i++) {
            System.out.println(" - " + highestOrder.getItems().get(i) + ": $" + highestOrder.getPrices().get(i));
        }
    }

    public static Order findHighestTotalOrder(Order... orders) {
        if (orders.length == 0) {
            throw new IllegalArgumentException("No orders provided.");
        }
        Order highestOrder = orders[0];
        for (Order order : orders) {

