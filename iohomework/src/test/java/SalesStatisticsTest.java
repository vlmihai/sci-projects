import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class SalesStatisticsTest {

    List<Sales> sales = new ArrayList<>();
    List<Client> clients = new ArrayList<>();
    List<Product> products = new ArrayList<>();


    @BeforeEach
    void setUp() {
        sales.add(new Sales(12,"iPhoneX",100,"John"));
        sales.add(new Sales(18,"Samsung",110,"Tim"));
        sales.add(new Sales(22,"Huawei",120,"Peter"));

        products.add(new Product("iPhoneX"));
        products.get(0).addSoldUnits(12);
        products.get(0).addPrice(100*12);
        products.add(new Product("Samsung"));
        products.get(1).addSoldUnits(18);
        products.get(1).addPrice(110*18);
        products.add(new Product("Huawei"));
        products.get(2).addSoldUnits(22);
        products.get(2).addPrice(120*22);

        clients.add(new Client("John"));
        clients.get(0).addUnitsBought(12);
        clients.get(0).addAmountSpent(sales.get(0).getSoldunits()*sales.get(0).getPrice());
        clients.add(new Client("Tim"));
        clients.get(1).addUnitsBought(18);
        clients.get(1).addAmountSpent(sales.get(1).getSoldunits()*sales.get(1).getPrice());
        clients.add(new Client("Peter"));
        clients.get(2).addUnitsBought(22);
        clients.get(2).addAmountSpent(sales.get(2).getSoldunits()*sales.get(2).getPrice());

    }

    @AfterEach
    void tearDown() {
        sales.clear();
        products.clear();
        clients.clear();
    }

    @Test
    void addSales() {
        HashMap<String,Product> productsHashMap = new HashMap<>();
        HashMap<String,Client> clientsHashMap = new HashMap<>();

        productsHashMap.put(products.get(0).getName(),products.get(0));
        productsHashMap.put(products.get(1).getName(),products.get(1));
        productsHashMap.put(products.get(2).getName(),products.get(2));
        clientsHashMap.put(clients.get(0).getName(),clients.get(0));
        clientsHashMap.put(clients.get(1).getName(),clients.get(1));
        clientsHashMap.put(clients.get(2).getName(),clients.get(2));

        SalesStatistics instance = new SalesStatistics();
        instance.addSales(sales.get(0));
        instance.addSales(sales.get(1));
        instance.addSales(sales.get(2));

        Assertions.assertEquals(productsHashMap,instance.productSalesHashMap);
        Assertions.assertEquals(clientsHashMap,instance.clientSalesHashMap);
    }

    @Test
    void statsUnitsSold() {
    }

    @Test
    void statsIncome() {
        HashMap<String,Product> productsHashMap = new HashMap<>();
        productsHashMap.put(products.get(2).getName(),products.get(2));
        productsHashMap.put(products.get(1).getName(),products.get(1));
        productsHashMap.put(products.get(0).getName(),products.get(0));

        Collection<Product> sales = productsHashMap.values();
        products = new ArrayList<>(sales);
        products.sort(Product.byIncome);

        SalesStatistics instance = new SalesStatistics();
        List<Product> expectedList = instance.statsIncome(productsHashMap);
        Assertions.assertEquals(products,expectedList);
    }

    @Test
    void statsUnitsSoldbyClient() {
        HashMap<String,Client> clientsHashMap = new HashMap<>();
        clientsHashMap.put(clients.get(0).getName(),clients.get(0));
        clientsHashMap.put(clients.get(1).getName(),clients.get(1));
        clientsHashMap.put(clients.get(2).getName(),clients.get(2));

        Collection<Client> sales = clientsHashMap.values();
        clients = new ArrayList<>(sales);
        clients.sort(Client.byUnitsbought);

        SalesStatistics instance = new SalesStatistics();
        List<Client> expectedList = instance.statsUnitsSoldbyClient(clientsHashMap);
        Assertions.assertEquals(clients,expectedList);

    }

    @Test
    void statsAmountSpentbyClient() {
    }

}
