public class VendingMachine {

    private final State noCoinState;
    private final State hasCoinState;
    private final State dispensingState;

    private State currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);

        currentState = noCoinState;
    }


    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getDispensingState() {
        return dispensingState;
    }

    public void setState(State state) {
        this.currentState = state;
    }
    
    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }
}