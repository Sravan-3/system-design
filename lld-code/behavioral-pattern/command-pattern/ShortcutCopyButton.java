public class ShortcutCopyButton implements Button {
    
    Command command;

    public ShortcutCopyButton(Command command){
        this.command = command;
    }

    @Override
    public void onClick() {
        command.execute();
    }

}
