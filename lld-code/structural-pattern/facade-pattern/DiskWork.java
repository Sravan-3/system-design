public class DiskWork {
    
    public void searchInDisk(){

        try{
            System.out.println("Searching in Disk..");
            Thread.sleep(2000);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Found the file");

    }
}
