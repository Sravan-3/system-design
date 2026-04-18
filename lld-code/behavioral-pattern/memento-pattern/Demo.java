public class Demo {
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
        History snapshots = new History();

        textEditor.write("Version: 1");
        snapshots.save(textEditor.save());
        System.out.println(textEditor.getContent());

        textEditor.write("Version: 2");
        snapshots.save(textEditor.save());
        System.out.println(textEditor.getContent());
        
        textEditor.write("Version: 3");
        snapshots.save(textEditor.save());
        System.out.println(textEditor.getContent());

        textEditor.write("Version: 4");
        System.out.println(textEditor.getContent());

        System.out.println("Undoing..");
        textEditor.restore(snapshots.undo());
        System.out.println(textEditor.getContent());

    }
}
