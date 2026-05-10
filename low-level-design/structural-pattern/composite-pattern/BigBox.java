import java.util.ArrayList;
import java.util.List;

public class BigBox implements Box {

    List<Box> bigBox = new ArrayList<>();

    public void addIteam(Box box){
        bigBox.add(box);
    }

    @Override
    public Double getPrice() {
        double price = 35.75;

        for(Box iteam : bigBox){
            price += iteam.getPrice();
        }

        return price;
    }
}
