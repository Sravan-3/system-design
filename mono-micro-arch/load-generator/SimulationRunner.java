import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationRunner {

    public static void main(String[] args) throws Exception {

        int users = 100000000;

        ExecutorService executor = Executors.newFixedThreadPool(200);

        for (int i = 0; i < users; i++) {
            executor.execute(new UserSimulation());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("✅ Load test finished");
    }
}
