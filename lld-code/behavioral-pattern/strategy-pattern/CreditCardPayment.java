public class CreditCardPayment implements PaymentStrategy {

    private PaymentDatabase database;

    public CreditCardPayment(PaymentDatabase database) {
        this.database = database;
    }

    @Override
    public boolean pay(User user, int amount) {

        if (!database.userExists(user)) {
            System.out.println("Invalid Credit Card details.");
            return false;
        }

        int balance = database.getBalance(user);

        if (balance < amount) {
            System.out.println("Insufficient balance in Credit Card.");
            return false;
        }

        database.updateBalance(user, balance - amount);

        System.out.println("Credit Card Payment Successful.");
        return true;
    }
}