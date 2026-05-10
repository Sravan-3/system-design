public class MacGuiFactory implements GuiFactory{

    @Override
    public Button createButton() {
        return new MacButtons();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
    
}
