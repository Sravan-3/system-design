public class Demo {
    public static void main(String[] args) {

        EmployeeRepository repo = new ProxyDatabase();

        System.out.println(repo.getEmpById(1)); // slow
        System.out.println(repo.getEmpById(1)); // fast (cache)

        System.out.println(repo.getEmpById(2)); // slow
        System.out.println(repo.getEmpById(2)); // fast (cache)
    }
}
