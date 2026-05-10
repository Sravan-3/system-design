public class Demo {
    public static void main(String[] args) {

        StringContainer stringContainer = new StringContainer();
        Iterator<String> namIterator = stringContainer.getInterator();

        while (namIterator.hasNext()) {
            System.out.println(namIterator.next());
        }
    }
}
