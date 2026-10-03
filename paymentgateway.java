import java.util.*;
interface PaymentMethod {
    void pay(double amount);
    void refund(double amount);
}
class UPIPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("UPI: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount) {
        System.out.println("UPI: Refund of " + amount + " successful");
    }
}
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("CREDIT: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount) {
        System.out.println("CREDIT: Refund of " + amount + " successful");
    }
}
class DebitCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("DEBIT: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount) {
        System.out.println("DEBIT: Refund of " + amount + " successful");
    }
}
class WalletPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("WALLET: Payment of " + amount + " successful");
    }
    @Override
    public void refund(double amount) {
        System.out.println("WALLET: Refund of " + amount + " successful");
    }
}
class PaymentProcessor {
    void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
public class paymentgateway{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentProcessor processor = new PaymentProcessor();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            PaymentMethod paymentMethod = null;
            if (type.equalsIgnoreCase("UPI")) {
                paymentMethod = new UPIPayment();
            } else if (type.equalsIgnoreCase("CREDIT")) {
                paymentMethod = new CreditCardPayment();
            } else if (type.equalsIgnoreCase("DEBIT")) {
                paymentMethod = new DebitCardPayment();
            } else if (type.equalsIgnoreCase("WALLET")) {
                paymentMethod = new WalletPayment();
            }
            if (paymentMethod != null) {
                processor.processPayment(paymentMethod, amount);
            }
        }
    }
}