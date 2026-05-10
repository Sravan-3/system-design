import java.util.HashMap;

public class ProxyDatabase implements EmployeeRepository {

    private SlowDatabase realDatabase; // lazy
    private HashMap<Integer, EmployeeData> cache = new HashMap<>();

    @Override
    public EmployeeData getEmpById(int id) {

        // Cache hit
        if (cache.containsKey(id)) {
            System.out.println("ProxyDatabase: Cache hit for id " + id);
            return cache.get(id);
        }

        // Lazy initialization
        if (realDatabase == null) {
            realDatabase = new SlowDatabase();
        }

        System.out.println("ProxyDatabase: Cache miss for id " + id);
        EmployeeData data = realDatabase.getEmpById(id);
        cache.put(id, data);
        return data;
    }
}
