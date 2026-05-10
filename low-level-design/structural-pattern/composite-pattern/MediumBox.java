import java.util.ArrayList;
import java.util.List;

public class MediumBox implements Box{

    List<Box> mediumBox = new ArrayList<>();

    public void addIteam(Box box){
        mediumBox.add(box);
    }

    @Override
    public Double getPrice() {
        double price = 27.75;

        for(Box iteam : mediumBox){
            price += iteam.getPrice();
        }

        return price;
    }
    
}
