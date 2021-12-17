package e1;

import org.junit.jupiter.api.Test;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    //             RAW       OR     AND
    //Origin
    //Destination
    //Price
    //Date

    TicketManager setUp() {
        TicketManager list = new TicketManager();

        list.addTicket("A Coruña", "Madrid", 120, "12/12/2022");
        list.addTicket("Ourense", "Madrid", 120, "21/12/2022");
        list.addTicket("Santiago", "Madrid", 100, "12/12/2022");
        list.addTicket("Madrid", "A Coruña", 120, "30/12/2022");
        list.addTicket("Madrid", "Castilla", 80, "30/12/2022");
        list.addTicket("Canarias", "Castilla", 180, "1/1/2023");

        return list;
    }

    @Test
    public void test1() {

        //OR origin
        //OR destination

        TicketManager list = setUp();

        String a;

        list.addCriteria(TicketManager.type.origin, "A Coruña");
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022");

        list.addCriteria(TicketManager.connector.OR, TicketManager.type.origin, "Madrid");

        a = list.ticketsToString(list.search());


        a = list.ticketsToString(list.search());
    }
}
