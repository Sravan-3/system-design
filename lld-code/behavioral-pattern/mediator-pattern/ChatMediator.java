import java.util.ArrayList;
import java.util.List;

public class ChatMediator {
    
    List<ChatInterface> users = new ArrayList<>();

    public void addUsers(ChatInterface user){
        users.add(user);
    }

    public void messageBroadcast(ChatInterface expectUser){

        for(ChatInterface user : users){

            if (user != expectUser){
                user.notifyUser(expectUser.getMessage());
            }

        }

    }

}
