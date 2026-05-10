public class Demo {
    public static void main(String[] args) {
        
        GuiFactory guiFactory = new MacGuiFactory();

        Button b1 =  guiFactory.createButton();
        CheckBox c1 = guiFactory.createCheckBox();

        b1.paint();
        c1.paint();
    }
}
