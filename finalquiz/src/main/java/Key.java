import java.util.Objects;
import java.util.function.Function;

public class Key {

    private String location;
    private String deliveryDate;

    public Key(String location, String deliveryDate) {
        this.location = location;
        this.deliveryDate = deliveryDate;
    }

    public Key(){}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Key{" +
                "location='" + location + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(location, key.location) &&
                Objects.equals(deliveryDate, key.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, deliveryDate);
    }
}
