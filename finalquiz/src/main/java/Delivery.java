public class Delivery {
    private String location;
    private Double distance;
    private Double value;
    private String deliveryDate;

    public Delivery(String location, Double distance, Double value, String deliveryDate) {
        this.location = location;
        this.distance = distance;
        this.value = value;
        this.deliveryDate = deliveryDate;
    }

    public Delivery(){
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "location='" + location + '\'' +
                ", distance=" + distance +
                ", value=" + value +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
