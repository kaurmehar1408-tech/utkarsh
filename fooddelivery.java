import java.util.*;
class Address {
    private String city;
    public Address(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
}
class Customer {
    private String name;
    private Address address;
    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
}
class Restaurant {
    private String name;
    public Restaurant(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class FoodItem {
    private String name;
    private double price;
    private int quantity;
    public FoodItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public double getTotalPrice() {
        return price * quantity;
    }
}
class Order {
    private Customer customer;
    private Restaurant restaurant;
    private List<FoodItem> items;
    private static final double DELIVERY_CHARGE = 50.0;
    private static final double TAX_RATE = 0.05; 
    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
    }
    public void addItem(FoodItem item) {
        items.add(item);
    }
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (FoodItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }
    public double calculateDiscount(double subtotal) {
        if (subtotal >= 1000) {
            return 0.10 * subtotal;
        }
        return 0.0;
    }
    public double calculateTax(double amountAfterDiscount) {
        return amountAfterDiscount * TAX_RATE;
    }
    public double calculateFinalBill(double subtotal, double discount, double tax) {
        return (subtotal - discount) + tax + DELIVERY_CHARGE;
    }
    public void printOrderDetails() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double amountAfterDiscount = subtotal - discount;
        double tax = calculateTax(amountAfterDiscount);
        double finalBill = calculateFinalBill(subtotal, discount, tax);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Delivery Charge: " + DELIVERY_CHARGE);
        System.out.println("Final Bill: " + finalBill);
    }
}

public class fooddelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        String city = sc.nextLine();
        Address address = new Address(city);
        Customer customer = new Customer(customerName, address);
        String restaurantName = sc.nextLine();
        Restaurant restaurant = new Restaurant(restaurantName);
        Order order = new Order(customer, restaurant);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String itemName = sc.next();
                double price = sc.nextDouble();
                int quantity = sc.nextInt();
                FoodItem item = new FoodItem(itemName, price, quantity);
                order.addItem(item);
            }
        }
        order.printOrderDetails();
    }
}