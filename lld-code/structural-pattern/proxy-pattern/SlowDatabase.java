import java.util.HashMap;

public class SlowDatabase implements EmployeeRepository {

    private HashMap<Integer, EmployeeData> empAllData = new HashMap<>();

    public SlowDatabase() {
        System.out.println("SlowDatabase: Loading data...");
        sleep(3000);
        loadTestData();
        System.out.println("SlowDatabase: Data loaded");
    }

    @Override
    public EmployeeData getEmpById(int id) {

        System.out.println("SlowDatabase: Fetching employee id " + id);
        sleep(3000);

        return empAllData.get(id);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    private void loadTestData() {
        empAllData.put(1, new EmployeeData(1, "John Smith", "EMP1001", "Payments", "Bangalore", 1200000));
        empAllData.put(2, new EmployeeData(2, "Alice Johnson", "EMP1002", "Search", "Hyderabad", 1350000));
        empAllData.put(3, new EmployeeData(3, "Robert Brown", "EMP1003", "Ads", "Pune", 1100000));
        empAllData.put(4, new EmployeeData(4, "Emily Davis", "EMP1004", "Payments", "Chennai", 1450000));
        empAllData.put(5, new EmployeeData(5, "Michael Wilson", "EMP1005", "Search", "Noida", 1600000));
    }
}
