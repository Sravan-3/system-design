public class Demo {
    public static void main(String[] args) {

        ChatMediator chatMediator = new ChatMediator();

        AliceChat alice =  new AliceChat(chatMediator);
        BobChat bob = new BobChat(chatMediator);
        CharileChat charile = new CharileChat(chatMediator);

        alice.sendMessage("Hello, Everyone!");

        bob.sendMessage("Hi, Alice.");

        charile.sendMessage("Hi Alice and bob!");
    }
}
