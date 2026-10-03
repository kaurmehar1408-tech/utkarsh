import java.util.*;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    double calculateFinalPrice() {
        return price;
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return price + (0.18 * price) + 1000;
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        double discountedPrice = price - (0.10 * price);
        return discountedPrice + (0.05 * discountedPrice);
    }
}

class Book extends Product {
    Book(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return price + (0.05 * price);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();

            if (type.equalsIgnoreCase("ELECTRONICS")) {
                products[i] = new Electronics(id, name, price);
            } else if (type.equalsIgnoreCase("CLOTHING")) {
                products[i] = new Clothing(id, name, price);
            } else if (type.equalsIgnoreCase("BOOK")) {
                products[i] = new Book(id, name, price);
            }
        }
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.name + ": " + p.calculateFinalPrice());
            }
        }
    }
}
