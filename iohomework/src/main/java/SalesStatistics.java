import java.util.*;

/**
 * This class is used to generate statistics based on Clients and Products.
 * Clients and Products are stored in two separate HashMaps.
 */

class SalesStatistics {

    // key - product name, value - product object
    HashMap<String, Product> productSalesHashMap = new HashMap<>();

    // key - client name, value - sales object
    HashMap<String, Client> clientSalesHashMap = new HashMap<>();

    /**
     * @param sales represents a Sales Object that is added to the statistics.
     *              updates both HashMaps.
     */

    void addSales (Sales sales){
        Product productName = getProductfromMap(sales.getName());
        Client clientName = getClientfromMap(sales.getClient());
        productName.addSoldUnits(sales.getSoldunits());
        productName.addPrice(sales.getPrice()*sales.getSoldunits());
        clientName.addUnitsBought(sales.getSoldunits());
        clientName.addAmountSpent(sales.getPrice()*sales.getSoldunits());
    }

    /**
     * @param productName updates the Product Object in HashMap or creates a new one.
     * @return
     */
    private Product getProductfromMap(String productName) {
        Product product;
        if (!productSalesHashMap.containsKey(productName)) {
            product = new Product(productName);
            productSalesHashMap.put(productName, product);
        } else {
            product = productSalesHashMap.get(productName);
        }
        return product;
    }

    /**
     * @param clientName updates the Client Object in HashMap or creates a new one.
     * @return
     */
    private Client getClientfromMap(String clientName) {
        Client client;
        if (!clientSalesHashMap.containsKey(clientName)) {
            client = new Client(clientName);
            clientSalesHashMap.put(clientName, client);
        } else {
            client = clientSalesHashMap.get(clientName);
        }
        return client;
    }

    List<Product> statsUnitsSold(HashMap<String, Product> productHashMap) {
        Collection<Product> sales = productHashMap.values();
        List<Product> salesList = new ArrayList<>(sales);
        salesList.sort(Product.bySoldUnits.thenComparing(Product::getName));
        return salesList;
    }

    List<Product> statsIncome(HashMap<String, Product> productHashMap) {
        Collection<Product> sales = productHashMap.values();
        List<Product> salesList = new ArrayList<>(sales);
        salesList.sort(Product.byIncome.thenComparing(Product::getName));
        return salesList;
    }

    List<Client> statsUnitsSoldbyClient(HashMap<String, Client> clientHashMap) {
        Collection<Client> sales = clientHashMap.values();
        List<Client> salesList = new ArrayList<>(sales);
        salesList.sort(Client.byUnitsbought.thenComparing(Client::getName));
        return salesList;
    }

    List<Client> statsAmountSpentbyClient(HashMap<String, Client> clientHashMap) {
        Collection<Client> sales = clientHashMap.values();
        List<Client> salesList = new ArrayList<>(sales);
        salesList.sort(Client.byAmountspent.thenComparing(Client::getName));
        return salesList;
    }

}