package e1;

import org.junit.jupiter.api.Test;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    //             RAW       OR     AND
    //Origin       ----      ---    ----
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

        //Origin

        TicketManager list = setUp();

        list.addCriteria(TicketManager.type.origin, "A Coruña");
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022");

        list.addCriteria(TicketManager.connector.OR, TicketManager.type.origin, "Madrid");
        assertEquals(list.ticketsToString(list.search()), """
                A Coruña - Madrid 120€ 12/12/2022
                Madrid - A Coruña 120€ 30/12/2022
                Madrid - Castilla 80€ 30/12/2022""");

        list.addCriteria(TicketManager.connector.AND, TicketManager.type.origin, "Castilla");
        assertEquals(list.ticketsToString(list.search()), "");
    }

    @Test
    public void test2() {

        //Destination

        TicketManager list = setUp();

        list.addCriteria(TicketManager.type.origin, "A Coruña");
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022");

        list.addCriteria(TicketManager.connector.OR, TicketManager.type.origin, "Madrid");
        assertEquals(list.ticketsToString(list.search()), """
                A Coruña - Madrid 120€ 12/12/2022
                Madrid - A Coruña 120€ 30/12/2022
                Madrid - Castilla 80€ 30/12/2022""");

        list.addCriteria(TicketManager.connector.AND, TicketManager.type.origin, "Castilla");
        assertEquals(list.ticketsToString(list.search()), "");
    }

    @Test
    public void test3() {

        //Price¡

        TicketManager list = setUp();

        list.addCriteria(TicketManager.type.price, TicketManager.condition.MoreThan, 100);
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022\n" +
                "Ourense - Madrid 120€ 21/12/2022\n" +
                "Madrid - A Coruña 120€ 30/12/2022\n" +
                "Canarias - Castilla 180€ 1/1/2023");

        list.addCriteria(TicketManager.connector.AND, TicketManager.type.price, TicketManager.condition.LessThan, 150);
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022\n" +
                "Ourense - Madrid 120€ 21/12/2022\n" +
                "Madrid - A Coruña 120€ 30/12/2022");

        list.addCriteria(TicketManager.connector.OR, TicketManager.type.price, TicketManager.condition.MoreThan, 1);
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022\n" +
                "Ourense - Madrid 120€ 21/12/2022\n" +
                "Madrid - A Coruña 120€ 30/12/2022");
    }


    @Test
    public void test4() {

        //Date

        TicketManager list = setUp();

        list.addCriteria(TicketManager.type.date, "12/12/2022");
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022\n" +
                "Santiago - Madrid 100€ 12/12/2022");

        list.addCriteria(TicketManager.connector.OR, TicketManager.type.date, "30/12/2022");
        assertEquals(list.ticketsToString(list.search()), "A Coruña - Madrid 120€ 12/12/2022\n" +
                "Santiago - Madrid 100€ 12/12/2022");

        list.addCriteria(TicketManager.connector.AND, TicketManager.type.date, "12/12/2022");
        assertEquals(list.ticketsToString(list.search()), "");
    }
}
