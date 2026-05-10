import java.util.HashMap;
import java.util.Map;

public class PaymentDatabase {

    private Map<User, Integer> users = new HashMap<>();

    public PaymentDatabase() {
        
        users.put(new User("1234-5678-987", "381"), 10000);
        users.put(new User("9877-3453-214", "212"), 50000);
        users.put(new User("alice@email.com", "Alice@123"), 30000);
        users.put(new User("bob@email.com", "BobLoveAlice@143"), 80000);
    }

    public boolean userExists(User user) {
        return users.containsKey(user);
    }

    public int getBalance(User user) {
        return users.get(user);
    }

    public void updateBalance(User user, int newBalance) {
        users.put(user, newBalance);
    }
}