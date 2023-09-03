import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18);
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20);
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("SVX", "SPB");
        Ticket[] expected = {ticket2, ticket8, ticket1, ticket9, ticket4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortEmptyArrayTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18);
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20);
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("SVX", "VVO");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortSingleArrayTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18);
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20);
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("SVX", "AER");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18); //3
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20); //4
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12); //2
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);     //5
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);  //3
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SVX", "SPB", comparator);
        Ticket[] expected = {ticket4, ticket1, ticket9, ticket2, ticket8};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void testSortEmptyArrayTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18);
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20);
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("VVO", "SPB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void testSortSingleArrayTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "SPB", 10_000, 15, 18);
        Ticket ticket2 = new Ticket("SVX", "SPB", 9_000, 16, 20);
        Ticket ticket3 = new Ticket("SVX", "AER", 13_000, 8, 12);
        Ticket ticket4 = new Ticket("SVX", "SPB", 11_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "AER", 7_000, 22, 24);
        Ticket ticket6 = new Ticket("VVO", "AER", 23_000, 6, 13);
        Ticket ticket7 = new Ticket("VVO", "SVX", 15_000, 12, 16);
        Ticket ticket8 = new Ticket("SVX", "SPB", 9_500, 5, 10);
        Ticket ticket9 = new Ticket("SVX", "SPB", 10_500, 11, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "AER", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }
}
