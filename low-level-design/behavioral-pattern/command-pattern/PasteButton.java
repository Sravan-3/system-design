public class PasteButton implements Button {

    Command command;

    public PasteButton(Command command){
        this.command = command;
    }
    
    @Override
    public void onClick() {
        command.execute();    
    }
    
}
