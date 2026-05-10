public abstract class Dialog {

    public void render(){
        Button button = CreateButton();
        button.render();
    }

    public abstract Button CreateButton();

}
