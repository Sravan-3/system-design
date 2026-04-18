public class BobChat implements ChatInterface {

    String message = new String();
    ChatMediator chatMediator;

    public BobChat(ChatMediator chatMediator){
        this.chatMediator = chatMediator;
        chatMediator.addUsers(this);
    }
    

    @Override
    public void sendMessage(String message) {
        this.message = message;
        chatMediator.messageBroadcast(this);
    }

    @Override
    public String getMessage() {
        return "Bob said: "+ message;
    }

    @Override
    public void notifyUser(String message) {
        System.out.println("Bob Recevied: " +message);
    }
    
}
