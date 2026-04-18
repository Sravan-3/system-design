public class Circle implements Shape{

    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public Shape clone(){
        return new Circle(radius);
    }

        @Override
    public void printShape(){
        System.out.printf("This is Circle of radis: %d\n",radius);
    }
    
}
