public class EditMemento {
    private final String content;

    public EditMemento(String content){
        this.content = content;
    }

    public String getSavedContent(){
        return this.content;
    }
}
