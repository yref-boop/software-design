package e1;

import java.util.ArrayList;

public class Price extends ObjectList<Price> {
    public int price;
    public condition con;

    @Override
    public boolean meetsCondition(int i, ArrayList<ObjectList<?>> queue, Ticket ticket) {
        Price p = (Price) queue.get(i);
        return (p.con == TicketManager.condition.LessThan && ticket.price < p.price)
            || (p.con == TicketManager.condition.MoreThan && ticket.price > p.price)
            || (p.con == TicketManager.condition.Equal && ticket.price == p.price);
    }

}