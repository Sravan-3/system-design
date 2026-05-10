public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Button rendered using WIndows API");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("You clicked Windows Button");
    }
    
}
