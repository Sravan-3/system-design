import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    
    public void subscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unSubscribe(String eventType, EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventyType, File file){

        List<EventListener> users = listeners.get(eventyType);

        for(EventListener listener : users){
            listener.update(eventyType, file);
        }

    }

}
