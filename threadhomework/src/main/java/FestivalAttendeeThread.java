public class FestivalAttendeeThread implements Runnable{
    private TicketType ticketType;
    private FestivalGate festivalGate;

    FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
                        //= TicketType.getRandomTicket();
                        //= TicketType ticketType = TicketType.randomEnum(TicketType.class));
                        //= TicketType ticketType = TicketType.getRandomFromEnum(TicketType.class));
        this.festivalGate = festivalGate;
    }

    TicketType getTicketType() {
        return ticketType;
    }

    public void run(){
        this.festivalGate.validateTicket(this);
    }
}

