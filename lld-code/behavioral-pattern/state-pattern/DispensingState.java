public class DispensingState implements State {

    private final VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait. Item is being dispensed.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Cannot eject coin while dispensing.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed successfully.");
        machine.setState(machine.getNoCoinState());
    }
}