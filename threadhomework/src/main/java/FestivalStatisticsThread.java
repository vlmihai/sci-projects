import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class FestivalStatisticsThread implements Runnable {
    private FestivalGate festivalGate;

    FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    public void run() {
        int sum = 0;
        System.out.println("---------------------------");
        if (!festivalGate.getAttendees().isEmpty()) {
            for (Map.Entry<TicketType, AtomicInteger> entry : this.festivalGate.getAttendees().entrySet()) {
                sum += entry.getValue().get();
                System.out.println(entry);
                //System.out.println(entry.getKey() + ": " + entry.getValue());
                //System.out.printf("Ticket[%s] = %s%n", entry.getKey(), entry.getValue());
            }
            System.out.println("Total number of attendees: " + sum + "\n---------------------------");
        }
    }
}
