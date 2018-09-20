import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Sales Reader reads information from a file and converts in into a List of sale objects.
 * This List is used to generate statistics of sales.
 */

class SalesReader {

    private Reader reader;

    SalesReader(Reader reader) {
        this.reader = reader;
    }

    List<Sales> getSales () throws IOException {
        try (BufferedReader br = new BufferedReader(reader)){
            ArrayList<Sales> sales = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                sales.add(parseSale(line));
                line = br.readLine();
            }
            return sales;
        }
    }

    private Sales parseSale(String line) {
        String[] tokens = line.split(",");
        return new Sales(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
    }
}
