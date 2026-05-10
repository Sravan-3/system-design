public class AdvanceRemote extends Remote{

    int currentVolume;

    public AdvanceRemote(Device device){
        super(device);
    }

    void mute(){

        if(device.getVolume() > 0){
            currentVolume = device.getVolume();
            device.setVolume(0);
            return;
        }
        
        device.setVolume(currentVolume);
   }
    
}
