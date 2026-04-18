public class HasCoinState implements State {

    private final VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned.");
        machine.setState(machine.getNoCoinState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Dispensing item...");
        machine.setState(machine.getDispensingState());
    }
}