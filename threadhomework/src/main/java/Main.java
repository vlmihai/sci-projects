import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(statisticsThread, 0, 5, TimeUnit.SECONDS);

        List<Thread> attendees = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            attendees.add(new Thread(new FestivalAttendeeThread(TicketType.getRandomTicket(), gate)));
            attendees.get(i).start();
        }

        for (Thread thread : attendees) {
            if (thread.isAlive()) {
                thread.join();
            }
        }

        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
