package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    //             RAW       OR     AND
    //Origin       ----     ----
    //Destination  ----     ----
    //Price
    //Date

    TicketManager setUp() {
        TicketManager list = new TicketManager();

        list.addTicket("A Coruña", "Madrid", 120, "12/12/2022");
        //list.addTicket("Ourense", "Madrid", 120, "21/12/2022");
        list.addTicket("Santiago", "Madrid", 100, "12/12/2022");
        //list.addTicket("Madrid", "A Coruña", 120, "30/12/2022");
        list.addTicket("Madrid", "Castilla", 80, "30/12/2022");
        //list.addTicket("Canarias", "Castilla", 180, "1/1/2023");

        return list;
    }

    @Test
    public void test1() {

        //OR origin
        //OR destination

        TicketManager list = setUp();

        String a;

        //list.addCriteria(TicketManager.type.origin, "A Coruña");
        //list.addCriteria(TicketManager.connector.OR, TicketManager.type.origin, "Madrid");

        //a = list.ticketsToString(list.search());

        /*
        assertEquals("""
                A Coruña - Madrid 120€ 12/12/2022
                Madrid - A Coruña 120€ 30/12/2022
                Madrid - Castilla 80€ 30/12/2022""",list.ticketsToString(list.search()));*/

        list.addCriteria(TicketManager.type.destination, "Madrid");
        list.addCriteria(TicketManager.connector.AND, TicketManager.type.destination, "Castilla");

        //a = list.ticketsToString(list.search());

        /*
        assertEquals("""
                A Coruña - Madrid 120€ 12/12/2022
                Madrid - Castilla 80€ 30/12/2022""",list.ticketsToString(list.search()));*/




        //list.addCriteria(TicketManager.type.origin, "Santiago");
        //list.addCriteria(2, TicketManager.type.origin, "Ourense");
        //list.addCriteria(TicketManager.type.destination, "A Coruña");
        //list.addCriteria(2, TicketManager.type.destination, "Madrid");


        //assertEquals("[user1, user2, user3]", list.search().toString());
        //assertThrows(IllegalArgumentException.class, () -> test.getInterestsUser("user200"));

         //a = list.search().toString();
    }
}
