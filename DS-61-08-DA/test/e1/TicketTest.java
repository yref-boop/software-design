package e1;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void test() {
        TicketManager list = new TicketManager();

        list.addTicket("A Coruña", "Madrid", 120, "12/12/2022");
        list.addTicket("Ourense", "Madrid", 120, "21/12/2022");
        list.addTicket("Santiago", "Madrid", 100, "12/12/2022");
        list.addTicket("Madrid", "A Coruña", 120, "30/12/2022");
        list.addTicket("Madrid", "Castilla", 80, "30/12/2022");

        //list.addCriteria(TicketManager.type.origin, "Santiago");
        //list.addCriteria(2, TicketManager.type.origin, "Ourense");
        //list.addCriteria(TicketManager.type.destination, "A Coruña");
        //list.addCriteria(2, TicketManager.type.destination, "Madrid");
        list.addCriteria(TicketManager.type.price, TicketManager.condition.MoreThan, 99);
        list.addCriteria(1, TicketManager.type.price, TicketManager.condition.LessThan, 101);

        list.search();
    }
}
