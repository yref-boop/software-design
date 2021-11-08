package e2;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class e2Test {

    Apartment a1 = new Apartment(0,500,4,33,1,2000);
    Apartment a2 = new Apartment(1,0,5,44,1,3000);
    Apartment a3 = new Apartment(2,100,0,55,1,4000);
    Apartment a4 =new Apartment(3,200,1,0,1,5000);
    Apartment a5 = new Apartment(4,300,2,11,1,6000);
    Apartment a6 = new Apartment(5,500,3,22,1,1000);



    ArrayList<Apartment> apartments_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));

    Comparator<Apartment> c_base = new BasePriceComparator();
    Comparator<Apartment>  r_code = new RentCodeComparator();
    Comparator<Apartment>  f_price = new FullPriceComparator();
    Comparator<Apartment>  size = new SizeComparator();
    Comparator<Apartment>  pos_code = new PosCodeComparator();
    Comparator<Apartment> null_code = null;


    //individual tests:
    @Test
    void managerGetters(){
        Manager m = new Manager(apartments_list, null_code);
        Comparator<Apartment> comp = m.getComparator();
        ArrayList<Apartment> list = m.getApartments();
        assertEquals(comp, null_code);
        assertNull(comp);
        assertEquals(apartments_list, list);
    }


    @Test
    void printList(){
        Manager m = new Manager(apartments_list, null_code);
        m.printList();
    }

    @Test
    void NewVoidComparatorTest(){
        Manager m1 = new Manager(apartments_list, null_code);
        m1.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
        assertEquals(m1.apartments, check_list);
    }

    @Test
    void NewBasePriceComparatorTest (){
        Manager m2 = new Manager(apartments_list, c_base);
        m2.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a2, a3, a4, a5, a6, a1));
        assertEquals(m2.apartments, check_list);
    }

    @Test
    void NewRentCodeComparatorTest(){
        Manager m3 = new Manager(apartments_list, r_code);
        m3.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
        assertEquals(m3.apartments, check_list);
    }

    @Test
    void NewFullPriceComparatorTest(){
        Manager m4 = new Manager(apartments_list, f_price);
        m4.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a2, a3, a4, a5, a6, a1));
        assertEquals(m4.apartments, check_list);
    }

    @Test
    void NewSizeComparatorTest(){
        Manager m5 = new Manager(apartments_list, size);
        m5.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a6, a1, a2, a3, a4, a5));
        assertEquals(m5.apartments, check_list);
    }

    @Test
    void NewPosCodeComparatorTest(){
        Manager m6 = new Manager(apartments_list, pos_code);
        m6.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a4, a5, a6, a1, a2, a3));
        assertEquals(m6.apartments, check_list);
    }

    @Test
    void NewVoidNewRentCode(){
        Manager m7 = new Manager(apartments_list, null_code);
        m7.sortApartments();
        Manager m8 = new Manager(apartments_list, r_code);
        m8.sortApartments();
        assertEquals(m7.apartments, m8.apartments);
    }

    @Test
    void AllComparator(){

        Manager m9 = new Manager(apartments_list, null_code);
        m9.sortApartments();

        m9.setComparator(new RentCodeComparator());
        m9.sortApartments();
        Manager m10 = new Manager (apartments_list, new RentCodeComparator());
        m10.sortApartments();
        assertEquals(m9.apartments, m10.apartments);

        Manager m11 = new Manager(apartments_list, null_code);
        m11.setComparator(new PosCodeComparator());
        m11.sortApartments();
        Manager m12 = new Manager (apartments_list, new PosCodeComparator());
        m12.sortApartments();
        assertEquals(m11.apartments, m12.apartments);

        Manager m13 = new Manager(apartments_list, null_code);
        m13.setComparator(new BasePriceComparator());
        m13.sortApartments();
        Manager m14 = new Manager (apartments_list, new BasePriceComparator());
        m14.sortApartments();
        assertEquals(m13.apartments, m14.apartments);

        Manager m15 = new Manager(apartments_list, null_code);
        m15.setComparator(new FullPriceComparator());
        m15.sortApartments();
        Manager m16 = new Manager (apartments_list, new FullPriceComparator());
        m16.sortApartments();
        assertEquals(m15.apartments, m16.apartments);

        Manager m17 = new Manager(apartments_list, null_code);
        m17.setComparator(new SizeComparator());
        m17.sortApartments();
        Manager m18 = new Manager (apartments_list, new SizeComparator());
        m18.sortApartments();
        assertEquals(m17.apartments, m18.apartments);

    }

    @Test
    void setApartments(){
        Manager m19 = new Manager(apartments_list, null_code);
        Manager m20 = new Manager(null, null_code);
        m20.setApartments(apartments_list);
        assertEquals(m19.apartments, m20.apartments);
    }

    @Test
    void apartmentSetters(){

        Apartment a1 = new Apartment(1, 2, 3, 4, 5, 6);
        Apartment a2 = new Apartment();
        a2.setRent_code(1);
        a2.setBase_price(2);
        a2.setParking_spaces(3);
        a2.setPos_code(4);
        a2.setParking_price(5);
        a2.setSize(6);
        assertEquals(a1, a2);
    }

    @Test
    void apartmentGetters(){

        Apartment a3 = new Apartment(1, 2, 3, 4, 5, 6);
        int rent = a3.getRent_code();
        int base = a3.getBase_price();
        int parking = a3.getParking_spaces();
        int pos = a3.getPos_code();
        int p_price = a3.getParking_price();
        int size = a3.getSize();

        assertEquals(rent, 1);
        assertEquals(base, 2);
        assertEquals(parking, 3);
        assertEquals(pos, 4);
        assertEquals(p_price, 5);
        assertEquals(size,6);
    }

    @Test
    void hashApartment(){

        Apartment a4 = new Apartment(1,2,3,4,5,6);
        Apartment a5 = new Apartment(1,2,3,4,5,6);
        Apartment a6 = new Apartment(4,2,3,4,5,6);
        Apartment a7 = new Apartment(4,0,3,4,5,6);
        Apartment a8 = new Apartment(4,1,0,4,5,6);
        Apartment a9 = new Apartment(4,1,3,0,5,6);
        Apartment a10 = new Apartment(4,1,3,4,0,6);
        Apartment a11 = new Apartment(4,1,3,4,5,0);
        Apartment a12 = new Apartment(134, 234, 1122, 324, 32432432, 2);

        int hasha4 = a4.hashCode();
        int hasha5 = a5.hashCode();
        int hasha6 = a6.hashCode();
        int hasha7 = a7.hashCode();
        int hasha8 = a8.hashCode();
        int hasha9 = a9.hashCode();
        int hasha10 = a10.hashCode();
        int hasha11 = a11.hashCode();
        int hasha12 = a12.hashCode();

        assertEquals(hasha4, hasha5);
        assertEquals(hasha4, hasha6);
        assertNotEquals(hasha4, hasha7);
        assertNotEquals(hasha4, hasha8);
        assertNotEquals(hasha4, hasha9);
        assertNotEquals(hasha4, hasha10);
        assertNotEquals(hasha4, hasha11);
        assertNotEquals(hasha4, hasha12);

    }

    @Test
    void equalsApartment(){

        Apartment a4 = new Apartment(1,2,3,4,5,6);
        Apartment a5 = new Apartment(1,2,3,4,5,6);
        Apartment a6 = new Apartment(4,2,3,4,5,6);
        Apartment a7 = new Apartment(4,0,3,4,5,6);
        Apartment a8 = new Apartment(4,1,0,4,5,6);
        Apartment a9 = new Apartment(4,1,3,0,5,6);
        Apartment a10 = new Apartment(4,1,3,4,0,6);
        Apartment a11 = new Apartment(4,1,3,4,5,0);
        Apartment a12 = new Apartment(134, 234, 1122, 324, 32432432, 2);

        boolean eq45 = a4.equals(a5);
        boolean eq46 = a4.equals(a6);
        boolean eq47 = a4.equals(a7);
        boolean eq48 = a4.equals(a8);
        boolean eq49 = a4.equals(a9);
        boolean eq410 = a4.equals(a10);
        boolean eq411 = a4.equals(a11);
        boolean eq412 = a4.equals(a12);

        assertTrue(eq45);
        assertTrue(eq46);
        assertFalse(eq47);
        assertFalse(eq48);
        assertFalse(eq49);
        assertFalse(eq410);
        assertFalse(eq411);
        assertFalse(eq412);

    }
}
