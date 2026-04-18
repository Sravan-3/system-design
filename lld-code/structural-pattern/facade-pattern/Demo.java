public class Demo {
    public static void main(String[] args) {

        FacadeOperation facade = new FacadeOperation();

        int result = facade.calculate(1, 2, '+');
        System.out.println(result);
    }
}
