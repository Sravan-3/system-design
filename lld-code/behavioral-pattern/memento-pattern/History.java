import java.util.Stack;

public class History {
    
    Stack<EditMemento> history = new Stack<>();

    public void save(EditMemento editMemento){
        history.push(editMemento);
    }

    public EditMemento undo(){

        if(!history.isEmpty()){
            return history.pop();
        }

        return null;
    }

}
