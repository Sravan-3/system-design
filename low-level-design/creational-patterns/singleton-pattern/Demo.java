public class Demo {
    public static void main(String[] args) {

        Singleton instance1 = Singleton.getInstance("FOO");
        System.out.println(instance1.value);

        Singleton instance2 = Singleton.getInstance("BAR");
        System.out.println(instance2.value);
        
    }
}
