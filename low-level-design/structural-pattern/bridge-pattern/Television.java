public class Television implements Device{

    boolean power = false;
    int volume = 0;
    int channel = 0;

    @Override
    public boolean isEnabled() {
        return this.power;
    }

    @Override
    public void enable() {
        this.power = true;
    }

    @Override
    public void disable() {
        this.power = false;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Television Status\n\tPower: " + this.power + "\n\t Volume: " + this.volume + "\n\t Channel: " + this.channel + "\n\t".toString();
    }
    
}
