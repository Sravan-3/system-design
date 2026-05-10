public class ShortcutPasteButton implements Button{

    Command command;

    public ShortcutPasteButton(Command command){
        this.command = command;
    }

    @Override
    public void onClick() {
        command.execute();
    }
    
}
