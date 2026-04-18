public class Demo {
    public static void main(String[] args) {

        VendingMachine vm = new VendingMachine();

        vm.insertCoin();
        vm.dispenseItem();

        System.out.println("----");

        vm.insertCoin();
        vm.ejectCoin();

        System.out.println("----");

        vm.insertCoin();
        vm.dispenseItem();
        vm.dispenseItem(); 
    }
}