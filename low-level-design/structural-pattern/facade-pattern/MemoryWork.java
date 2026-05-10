public class MemoryWork {

    boolean hasInMemory = false;

    public void checkInMemory(){

        if (hasInMemory) {
            System.out.println("found in Memory");
            return;
        }

        System.out.println("Not in memory...fecthing from disk");
        
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }

}
