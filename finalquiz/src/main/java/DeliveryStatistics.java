import java.util.*;

class DeliveryStatistics implements Runnable{

    private LinkedHashMap <Key, List<Delivery>> deliveryMap = new LinkedHashMap<>();
    private double value = 0;
    private double revenue = 0;

    void addDeliveriesToMap (List<Delivery> deliveries) {

        for (Delivery delivery : deliveries) {
            Key key = new Key(delivery.getLocation(), delivery.getDeliveryDate());
            if (!deliveryMap.containsKey(key)) {
                LinkedList<Delivery> deliveries1 = new LinkedList<>();
                deliveries1.add(delivery);
                deliveryMap.put(key, deliveries1);
            } else {
                deliveryMap.get(key).add(delivery);
            }
        }
        /*deliveryMap.forEach((key, value) -> System.out.println("Location:" + key.getLocation() + " Date:" + key.getDeliveryDate() +
                "\nDeliveries: " + value + "\n"));*/
    }

    void deliveryStats (){
        List<Delivery> deliveries;
        for (Map.Entry<Key, List<Delivery>> entry : deliveryMap.entrySet()){
            //System.out.println("Location delivery: " + entry.getKey().getLocation() + " Date: " + entry.getKey().getDeliveryDate());
            //System.out.println("Deliveries: " + entry.getValue() + "\n");
            deliveries = entry.getValue();
            double totalValue = 0;
            double totalRevenue = 0;
            for (Delivery del : deliveries){
                totalValue += del.getValue();
                totalRevenue = del.getDistance();
            }
            /*System.out.println("Group: " + entry.getKey().getLocation() + " "+ entry.getKey().getDeliveryDate()
                    + " Value per group: " + totalValue + " Revenue per group: " + totalRevenue);*/
            value += totalValue;
            revenue += totalRevenue;
        }
    }

    @Override
    public void run() {
        for (Map.Entry<Key, List<Delivery>> entry : deliveryMap.entrySet()){
            long milli = (long)((entry.getValue().iterator().next().getDistance()) * 1000);
            Thread thread = new Thread();
            try {
                Thread.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
            System.out.println("Delivering for <"+entry.getKey().getLocation()+"> and date <"+entry.getKey().getDeliveryDate()+
                    "> in <"+entry.getValue().iterator().next().getDistance()+"> seconds");
        }
        System.out.println("\nTotal Value of all delivered packages: " + value + " RON");
        System.out.println("Total Revenue computed for all groups delivered: " + revenue + " RON");
    }
}

