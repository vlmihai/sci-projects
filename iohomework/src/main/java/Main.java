import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File ("product-sales.csv");
        if (!f.exists()) {
            System.out.println("File " + f.getName() + " does not exist.");
        }

        FileReader fr = new FileReader(f);
        List<Sales> sales = new SalesReader(fr).getSales();
        /*System.out.println("\nSales: ");
        for(int i = 0; i< sales.size(); i++){
            System.out.println(i+". " + sales.get(i));
        }*/

        SalesStatistics productStats = new SalesStatistics();
        for (Sales sales1 : sales){
            productStats.addSales(sales1);
        }

        SalesExporter exporter = new SalesExporter();
        exporter.writeStatsToFile(productStats);
    }
}
