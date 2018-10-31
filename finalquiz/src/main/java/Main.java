import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File ("deliveries.csv");
        if (!f.exists()) {
            System.out.println("File " + f.getName() + " does not exist.");
        }

        FileReader frDeliveries = new FileReader(f);
        List<Delivery> deliveries = new Reader(frDeliveries).getDeliveries();

        DeliveryStatistics deliveryStatistics = new DeliveryStatistics();
        deliveryStatistics.addDeliveriesToMap(deliveries);
        deliveryStatistics.deliveryStats();
        deliveryStatistics.run();
    }
}
