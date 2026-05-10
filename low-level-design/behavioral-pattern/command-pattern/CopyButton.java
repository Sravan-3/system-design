public class CopyButton implements Button {

    Command command;

    public CopyButton(Command command){
        this.command = command;
    }

    @Override
    public void onClick() {
        command.execute();
    }
    
}
