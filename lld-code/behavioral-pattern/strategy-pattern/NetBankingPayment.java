public class NetBankingPayment implements PaymentStrategy {

    private PaymentDatabase database;

    public NetBankingPayment(PaymentDatabase database) {
        this.database = database;
    }

    @Override
    public boolean pay(User user, int amount) {

        if (!database.userExists(user)) {
            System.out.println("Invalid Net Banking credentials.");
            return false;
        }

        int balance = database.getBalance(user);

        if (balance < amount) {
            System.out.println("Insufficient balance in Net Banking account.");
            return false;
        }

        database.updateBalance(user, balance - amount);

        System.out.println("Net Banking Payment Successful.");
        return true;
    }
}