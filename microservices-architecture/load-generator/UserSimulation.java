import java.net.HttpURLConnection;
import java.net.URL;

public class UserSimulation implements Runnable {

    @Override
    public void run() {
        try {
            int productId = (int)(Math.random() * 3) + 1;
            int qty = (int)(Math.random() * 3) + 1;

            String urlStr = "http://app:8080/order?productId="
                    + productId + "&qty=" + qty;

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.getResponseCode();

        } catch (Exception e) {
            // ignore
        }
    }
}
