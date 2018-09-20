import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * SalesExporter class is used to generate the output file and to write the statistics.
 */

class SalesExporter {

    void writeStatsToFile(SalesStatistics stats) throws IOException {
        File f = new File("stats.txt");
        if (f.exists()) {
            f.delete();
        } else {
            f.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            List<Product> products = stats.statsUnitsSold(stats.productSalesHashMap);
            bw.append("Product Sales by Units Sold: " + "\n");
            for (int i = 0; i < products.size(); i++) {
                bw.append((i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getSoldunits() + " units");
                bw.newLine();
            }
            bw.append("...");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
            List<Product> products = stats.statsIncome(stats.productSalesHashMap);
            bw.append("\n" + "Product Sales by Income: " + "\n");
            for (int i = 0; i < products.size(); i++) {
                bw.append((i + 1) + ". " + products.get(i).getName() + " - " + "$" + products.get(i).getPrice());
                bw.newLine();
            }
            bw.append("...");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
            List<Client> client = stats.statsUnitsSoldbyClient(stats.clientSalesHashMap);
            bw.append("\n" +"Product Sales by Client: " + "\n");
            for (int i = 0; i < client.size(); i++) {
                bw.append((i + 1) + ". " + client.get(i).getName() + " - " + client.get(i).getUnitsbought()+ " units");
                bw.newLine();
            }
            bw.append("...");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
            List<Client> client = stats.statsAmountSpentbyClient(stats.clientSalesHashMap);
            bw.append("\n" + "Amount Spent by Client: " + "\n");
            for (int i = 0; i < client.size(); i++) {
                bw.append((i + 1) + ". " + client.get(i).getName() + " - " + "$" + client.get(i).getAmountspent());
                bw.newLine();
            }
            bw.append("...");
        }
    }
}
