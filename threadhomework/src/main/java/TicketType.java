import java.security.SecureRandom;
import java.util.Random;

// Am scris mai multe metode care genereaza Random putin diferit

public enum TicketType {
    FREE, ONEDAY, TWODAY, FULL, ONEDAYVIP, TWODAYVIP, FULLVIP;

    // prima metoda
    public static TicketType getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    // a doua metoda
    public static TicketType getRandomTicket() {
        return values()[(int) (Math.random() * values().length)];
    }

    // a treia metoda
    public static <T extends Enum<TicketType>> T randomEnum(Class<T> clazz) {
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    // a parta metoda
    public static Object getRandomFromEnum(Class<? extends Enum<TicketType>> clazz) {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
