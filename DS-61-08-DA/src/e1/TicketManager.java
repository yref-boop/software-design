package e1;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    private final List<Ticket> tickets = new ArrayList<>();

    public void createTicket (String origin, String destination, int prize, String date) {
        Ticket t = new Ticket();
        t.setOrigin(origin);
        t.setDestination(destination);
        t.setPrize(prize);
        t.setDate(date);
        tickets.add(t);
    }

    public void filterTickets (String query) {

        String [] tokens = "That's the code".split("[\\W]");
        for(String s:tokens){
            System.out.println(s);
        }


        for (Ticket ticket : tickets) {

        }
    }

    //boolean isValid (Ticket ticket, String data, boolean canAND,  ) {

    //}

}
