public class Demo {
    public static void main(String[] args) {
        
        Button b1 = new CopyButton(new CopyCommand());
        Button b2 = new ShortcutCopyButton(new CopyCommand());
        Button b3 = new PasteButton(new PasteCommand());
        Button b4 = new ShortcutPasteButton(new PasteCommand());

        b1.onClick();
        b3.onClick();
        b2.onClick();
        b4.onClick();
    }
}
