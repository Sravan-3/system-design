public class TextEditor {

    private String content;

    public void write(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public EditMemento save(){
        return new EditMemento(this.content);
    }

    public void restore(EditMemento restore){
        this.content = restore.getSavedContent();
    }
    

}
