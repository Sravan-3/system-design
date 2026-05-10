import java.util.ArrayList;
import java.util.List;

public class SmallBox implements Box{

    List<Box> smallbox = new ArrayList<>();

    public void addIteam(Box box){
        smallbox.add(box);
    }

    @Override
    public Double getPrice() {

        double price = 18.75;// 18.75 for smallbox

        for (Box iteam: smallbox){
            price += iteam.getPrice();
        }

        return price;
    }
    
}
