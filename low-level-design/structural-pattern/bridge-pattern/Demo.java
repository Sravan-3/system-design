public class Demo {
    public static void main(String[] args) {

        Device television = new Television();
        AdvanceRemote remote = new AdvanceRemote(television);

        remote.togglePower();
        System.out.println(television);

        remote.volumeUp();
        remote.volumeUp();
        remote.volumeUp();
        remote.volumeUp();
        remote.volumeUp();

        System.out.println(television);

        remote.channelUp();
        System.out.println(television);

        remote.mute();
        System.out.println(television);

        remote.mute();
        System.out.println(television);

    }
}
