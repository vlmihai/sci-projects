import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class FestivalGate {
    private ConcurrentHashMap<TicketType, AtomicInteger> attendees = new ConcurrentHashMap<>();

    FestivalGate(){
    }

    void validateTicket(FestivalAttendeeThread attendee) {
        synchronized (this) {
            try {
                //Using sleep in AttendeeThread to simulate attendees entries through gate
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (attendees.containsKey(attendee.getTicketType())) {
                (attendees.get(attendee.getTicketType())).incrementAndGet();
            } else {
                attendees.put(attendee.getTicketType(), new AtomicInteger(1));
            }
            System.out.println("A person with a " + attendee.getTicketType() + "  passed through the gate from " +
                    Thread.currentThread().getName());
        }
    }

    ConcurrentHashMap<TicketType, AtomicInteger> getAttendees() {
        return attendees;
    }
}
