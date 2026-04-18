public interface PaymentStrategy {
    boolean pay(User user, int amount);
}