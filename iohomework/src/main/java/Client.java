import java.util.Comparator;
import java.util.Objects;

/**
 * Class Client used for generating statistics. All clients have a name, units bought and an amount spent.
 * I created custom comparators by units and amount spent.
 * HashMap from statistics is looking only by client's name.
 */

public class Client {
    private String name;
    private int unitsbought;
    private int amountspent;

    public Client(String name) {
        this.name = name;
    }

    void addUnitsBought (int unitsbought) { this.unitsbought += unitsbought; }

    void addAmountSpent (int amountspent) { this.amountspent += amountspent; }

    String getName() {
        return name;
    }

    int getUnitsbought() {
        return unitsbought;
    }

    int getAmountspent() {
        return amountspent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return unitsbought == client.unitsbought &&
                amountspent == client.amountspent &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitsbought, amountspent);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", unitsbought=" + unitsbought +
                ", amountspent=" + amountspent +
                '}';
    }

    static Comparator<Client> byUnitsbought = (c1, c2) -> {
        Integer Client1 = c1.getUnitsbought();
        Integer Client2 = c2.getUnitsbought();
        //descending order
        return Client2.compareTo(Client1);
    };

    static Comparator<Client> byAmountspent = (c1, c2) -> {
        Integer Client1 = c1.getAmountspent();
        Integer Client2 = c2.getAmountspent();
        //descending order
        return Client2.compareTo(Client1);
    };
}
