import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private FileReader reader;

    Reader(FileReader reader) {
        this.reader = reader;
    }

    List<Delivery> getDeliveries () throws IOException {
        try (BufferedReader br = new BufferedReader(reader)){
            ArrayList<Delivery> deliveries = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                deliveries.add(parseDelivery(line));
                line = br.readLine();
            }
            return deliveries;
        }
    }

    private Delivery parseDelivery(String line) {
        String[] tokens = line.split(",");
        return new Delivery(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
    }

}
