public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean executePayment(User user, int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment Strategy not set.");
        }
        return paymentStrategy.pay(user, amount);
    }
}