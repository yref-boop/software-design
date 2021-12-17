package e1;

import java.util.ArrayList;

public class Price extends ObjectList {
    public int price;
    public condition con;

    @Override
    public boolean doesNotMeetCondition(int i, ArrayList<ObjectList> queue, Ticket ticket) {
        Price p = (Price) queue.get(i);
        return (p.con != condition.LessThan || ticket.price >= p.price)
                && (p.con != condition.MoreThan || ticket.price <= p.price)
                && (p.con != condition.Equal || ticket.price != p.price);
    }

}