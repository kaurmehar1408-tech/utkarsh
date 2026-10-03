import java.util.*;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    static int totalAccounts = 0;
    static String bankName = "Utkarsh Bank";

    BankAccount(String accountHolder, double balance) {
        totalAccounts++;
        this.accountNumber = totalAccounts;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if(amount > 0){
            this.balance += amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    int getAccountNumber() {
        return accountNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        Map<Integer, BankAccount> accountsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double initialBalance = sc.nextDouble();
            
            BankAccount acc = new BankAccount(name, initialBalance);
            accountsMap.put(acc.getAccountNumber(), acc);
        }

        if (sc.hasNextInt()) {
            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                int accNum = sc.nextInt();
                String type = sc.next();
                double amount = sc.nextDouble();

                BankAccount acc = accountsMap.get(accNum);
                if (acc != null) {
                    if (type.equalsIgnoreCase("DEPOSIT")) {
                        acc.deposit(amount);
                    } else if (type.equalsIgnoreCase("WITHDRAW")) {
                        acc.withdraw(amount);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            BankAccount acc = accountsMap.get(i);
            if (acc != null) {
                acc.displayDetails();
            }
        }
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
