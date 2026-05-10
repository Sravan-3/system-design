public class Remote{

    Device device;

    public Remote(Device device){
        this.device = device;
    }

    void togglePower(){

        if (device.isEnabled()){
            device.disable();
            return;
        }

        device.enable();
    }

    void volumeDown(){

        device.setVolume(device.getVolume()- 1);
    }

    void volumeUp(){
    
        device.setVolume(device.getVolume() + 1);
    }

    void channelUp(){
        device.setChannel(device.getChannel() + 1);
    }


    void channelDown(){
        device.setChannel(device.getChannel() - 1);
    }

}
