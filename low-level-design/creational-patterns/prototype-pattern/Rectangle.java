public class Rectangle implements Shape{
    
    int height;
    int width;

    public Rectangle(int height, int width){

        this.height = height;
        this.width = width;
    }

    @Override
    public Shape clone(){
        return new Rectangle(height, width);
    }

    @Override
    public void printShape(){
        System.out.printf("This is rectangle of height: %d and width %d\n", height, width);
    }

}
