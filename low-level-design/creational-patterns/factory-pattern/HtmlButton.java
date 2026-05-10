public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("Button rendered using HTML");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("You clicked HTML Button");
    }

}
