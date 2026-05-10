import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentDatabase database = new PaymentDatabase();
        PaymentContext context = new PaymentContext();

        int totalAmount = 7000;

        System.out.println("Total amount: " + totalAmount);
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Net Banking");

        int choice = scanner.nextInt();
        scanner.nextLine();

        User user;

        if (choice == 1) {
            context.setPaymentStrategy(new CreditCardPayment(database));

            System.out.println("Enter card number:");
            String card = scanner.nextLine();

            System.out.println("Enter CVV:");
            String cvv = scanner.nextLine();

            user = new User(card, cvv);

        } else if (choice == 2) {
            context.setPaymentStrategy(new NetBankingPayment(database));

            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            user = new User(username, password);

        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        boolean success = context.executePayment(user, totalAmount);

        if (success) {
            System.out.println("Payment Completed Successfully.");
        } else {
            System.out.println("Payment Failed.");
        }

        scanner.close();
    }
}