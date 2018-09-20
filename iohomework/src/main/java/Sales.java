import java.util.Objects;

public class Sales implements Comparable<Sales>{
   private int soldunits;
   private String name;
   private int price;
   private String client;

    Sales(int soldunits, String name, int price, String client) {
        this.soldunits = soldunits;
        this.name = name;
        this.price = price;
        this.client = client;
    }

    Sales(String name) { this.name = name; }

    void addSoldunits(int soldunits) {
        this.soldunits += soldunits;
    }

    void addPrice(int price) { this.price = price; }

    void addClient (String client) { this.client = client; }

    int getSoldunits() {
        return soldunits;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    String getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "soldunits=" + soldunits +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", client='" + client + '\'' +
                '}';
    }
    @Override
    public int compareTo(Sales o) { return o.getSoldunits() - soldunits; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return soldunits == sales.soldunits &&
                price == sales.price &&
                Objects.equals(name, sales.name) &&
                Objects.equals(client, sales.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soldunits, name, price, client);
    }
}
