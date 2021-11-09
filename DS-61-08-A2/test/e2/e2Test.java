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
    Apartment a6 = new Apartment(5,400,3,22,1,1000);
    Apartment an = null;

    ArrayList<Apartment> apartments_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
    ArrayList<Apartment> null_apartments = new ArrayList<>(Arrays.asList(an, an, an, an, an ,an));
    ArrayList<Apartment> mixed_apartments = new ArrayList<>(Arrays.asList(an, a1, a3, an, a5));

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
    void NewVoidComparatorTest(){
        Manager m1 = new Manager(apartments_list, null_code);
        m1.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
        assertEquals(m1.apartments, check_list);
    }

    @Test
    void VoidBaseComparator(){
        Manager mv = null;
        assertThrows(NullPointerException.class, () -> mv.sortApartments());
    }

    @Test
    void NullBasePriceComparator(){
        Manager mv = new Manager(null_apartments, c_base);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }
    @Test
    void SemiNullBasePriceComparator(){
        Manager mv = new Manager(mixed_apartments, c_base);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void NewBasePriceComparatorTest (){
        Manager m2 = new Manager(apartments_list, c_base);
        m2.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a2, a3, a4, a5, a6, a1));
        assertEquals(m2.apartments, check_list);
    }

    @Test
    void NullRentCodeComparator(){
        Manager mv = new Manager(null_apartments, r_code);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void SemiNullRentCodeComparator(){
        Manager mv = new Manager(mixed_apartments, r_code);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void NewRentCodeComparatorTest(){
        Manager m3 = new Manager(apartments_list, r_code);
        m3.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6));
        assertEquals(m3.apartments, check_list);
    }

    @Test
    void NullFullPriceComparator(){
        Manager mv = new Manager(null_apartments, f_price);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void SemiNullFullPriceComparator(){
        Manager mv = new Manager(mixed_apartments, f_price);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void NewFullPriceComparatorTest(){
        Manager m4 = new Manager(apartments_list, f_price);
        m4.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a2, a3, a4, a5, a6, a1));
        assertEquals(m4.apartments, check_list);
    }

    @Test
    void NullSizeComparator(){
        Manager mv = new Manager(null_apartments, size);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void SemiNullSizeComparator(){
        Manager mv = new Manager(mixed_apartments, size);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void NewSizeComparatorTest(){
        Manager m5 = new Manager(apartments_list, size);
        m5.sortApartments();
        ArrayList<Apartment> check_list = new ArrayList<>(Arrays.asList(a6, a1, a2, a3, a4, a5));
        assertEquals(m5.apartments, check_list);
    }

    @Test
    void NullPosCodeComparator(){
        Manager mv = new Manager(null_apartments, pos_code);
        assertThrows(NullPointerException.class, mv::sortApartments);
    }

    @Test
    void SemiNullPosCodeComparator(){
        Manager mv = new Manager(mixed_apartments, pos_code);
        assertThrows(NullPointerException.class, mv::sortApartments);
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
        Apartment a13 = null;

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
        assertThrows(NullPointerException.class, () -> {a13.hashCode();});

    }

    @Test
    void equalsApartment(){

        Apartment a0  = new Apartment(0,0,0,0,0,0);
        Apartment a1  = new Apartment(1,0,0,0,0,0);
        Apartment a2  = new Apartment(0,0,0,0,0,1);
        Apartment a3  = new Apartment(1,0,0,0,0,1);
        Apartment a4  = new Apartment(0,0,0,0,1,0);
        Apartment a5  = new Apartment(1,0,0,0,1,0);
        Apartment a6  = new Apartment(0,0,0,0,1,1);
        Apartment a7  = new Apartment(1,0,0,0,1,1);
        Apartment a8  = new Apartment(0,0,0,1,0,0);
        Apartment a9  = new Apartment(1,0,0,1,0,0);
        Apartment a10 = new Apartment(0,0,0,1,0,1);
        Apartment a11 = new Apartment(1,0,0,1,0,1);
        Apartment a12 = new Apartment(0,0,0,1,1,0);
        Apartment a13 = new Apartment(1,0,0,1,1,0);
        Apartment a14 = new Apartment(0,0,0,1,1,1);
        Apartment a15 = new Apartment(1,0,0,1,1,1);
        Apartment a16 = new Apartment(0,0,1,0,0,0);
        Apartment a17 = new Apartment(1,0,1,0,0,0);
        Apartment a18 = new Apartment(0,0,1,0,0,1);
        Apartment a19 = new Apartment(1,0,1,0,0,1);
        Apartment a20 = new Apartment(0,0,1,0,1,0);
        Apartment a21 = new Apartment(1,0,1,0,1,0);
        Apartment a22 = new Apartment(0,0,1,0,1,1);
        Apartment a23 = new Apartment(1,0,1,0,1,1);
        Apartment a24 = new Apartment(0,0,1,1,0,0);
        Apartment a25 = new Apartment(1,0,1,1,0,0);
        Apartment a26 = new Apartment(0,0,1,1,0,1);
        Apartment a27 = new Apartment(1,0,1,1,0,1);
        Apartment a28 = new Apartment(0,0,1,1,1,0);
        Apartment a29 = new Apartment(1,0,1,1,1,0);
        Apartment a30 = new Apartment(0,0,1,1,1,1);
        Apartment a31 = new Apartment(1,0,1,1,1,1);
        Apartment a32 = new Apartment(0,1,0,0,0,0);
        Apartment a33 = new Apartment(1,1,0,0,0,0);
        Apartment a34 = new Apartment(0,1,0,0,0,1);
        Apartment a35 = new Apartment(1,1,0,0,0,1);
        Apartment a36 = new Apartment(0,1,0,0,1,0);
        Apartment a37 = new Apartment(1,1,0,0,1,0);
        Apartment a38 = new Apartment(0,1,0,0,1,1);
        Apartment a39 = new Apartment(1,1,0,0,1,1);
        Apartment a40 = new Apartment(0,1,0,1,0,0);
        Apartment a41 = new Apartment(1,1,0,1,0,0);
        Apartment a42 = new Apartment(0,1,0,1,0,1);
        Apartment a43 = new Apartment(1,1,0,1,0,1);
        Apartment a44 = new Apartment(0,1,0,1,1,0);
        Apartment a45 = new Apartment(1,1,0,1,1,0);
        Apartment a46 = new Apartment(0,1,0,1,1,1);
        Apartment a47 = new Apartment(1,1,0,1,1,1);
        Apartment a48 = new Apartment(0,1,1,0,0,0);
        Apartment a49 = new Apartment(1,1,1,0,0,0);
        Apartment a50 = new Apartment(0,1,1,0,0,1);
        Apartment a51 = new Apartment(1,1,1,0,0,1);
        Apartment a52 = new Apartment(0,1,1,0,1,0);
        Apartment a53 = new Apartment(1,1,1,0,1,0);
        Apartment a54 = new Apartment(0,1,1,0,1,1);
        Apartment a55 = new Apartment(1,1,1,0,1,1);
        Apartment a56 = new Apartment(0,1,1,1,0,0);
        Apartment a57 = new Apartment(1,1,1,1,0,0);
        Apartment a58 = new Apartment(0,1,1,1,0,1);
        Apartment a59 = new Apartment(1,1,1,1,0,1);
        Apartment a60 = new Apartment(0,1,1,1,1,0);
        Apartment a61 = new Apartment(1,1,1,1,1,0);
        Apartment a62 = new Apartment(0,1,1,1,1,1);
        Apartment a63 = new Apartment(1,1,1,1,1,1);

        Apartment a64 = new Apartment(1,1,1,1,1,1);
        Apartment a65 = new Apartment(170,170,170,170,170,170);
        Apartment a66 = new Apartment(7000,7000,7000,7000,7000,7000);
        Apartment a67 = null;
        Object a68 = new Object();
        Apartment a69 = new Apartment(-1,-1,-1,-1,-1,-1);


        boolean eq0  = a63.equals(a0);
        boolean eq1  = a63.equals(a1);
        boolean eq2  = a63.equals(a2);
        boolean eq3  = a63.equals(a3);
        boolean eq4  = a63.equals(a4);
        boolean eq5  = a63.equals(a5);
        boolean eq6  = a63.equals(a6);
        boolean eq7  = a63.equals(a7);
        boolean eq8  = a63.equals(a8);
        boolean eq9  = a63.equals(a9);
        boolean eq10 = a63.equals(a10);
        boolean eq11 = a63.equals(a11);
        boolean eq12 = a63.equals(a12);
        boolean eq13 = a63.equals(a13);
        boolean eq14 = a63.equals(a14);
        boolean eq15 = a63.equals(a15);
        boolean eq16 = a63.equals(a16);
        boolean eq17 = a63.equals(a17);
        boolean eq18 = a63.equals(a18);
        boolean eq19 = a63.equals(a19);
        boolean eq20 = a63.equals(a20);
        boolean eq21 = a63.equals(a21);
        boolean eq22 = a63.equals(a22);
        boolean eq23 = a63.equals(a23);
        boolean eq24 = a63.equals(a24);
        boolean eq25 = a63.equals(a25);
        boolean eq26 = a63.equals(a26);
        boolean eq27 = a63.equals(a27);
        boolean eq28 = a63.equals(a28);
        boolean eq29 = a63.equals(a29);
        boolean eq30 = a63.equals(a30);
        boolean eq31 = a63.equals(a31);
        boolean eq32 = a63.equals(a32);
        boolean eq33 = a63.equals(a33);
        boolean eq34 = a63.equals(a34);
        boolean eq35 = a63.equals(a35);
        boolean eq36 = a63.equals(a36);
        boolean eq37 = a63.equals(a37);
        boolean eq38 = a63.equals(a38);
        boolean eq39 = a63.equals(a39);
        boolean eq40 = a63.equals(a40);
        boolean eq41 = a63.equals(a41);
        boolean eq42 = a63.equals(a42);
        boolean eq43 = a63.equals(a43);
        boolean eq44 = a63.equals(a44);
        boolean eq45 = a63.equals(a45);
        boolean eq46 = a63.equals(a46);
        boolean eq47 = a63.equals(a47);
        boolean eq48 = a63.equals(a48);
        boolean eq49 = a63.equals(a49);
        boolean eq50 = a63.equals(a50);
        boolean eq51 = a63.equals(a51);
        boolean eq52 = a63.equals(a52);
        boolean eq53 = a63.equals(a53);
        boolean eq54 = a63.equals(a54);
        boolean eq55 = a63.equals(a55);
        boolean eq56 = a63.equals(a56);
        boolean eq57 = a63.equals(a57);
        boolean eq58 = a63.equals(a58);
        boolean eq59 = a63.equals(a59);
        boolean eq60 = a63.equals(a60);
        boolean eq61 = a63.equals(a61);
        boolean eq62 = a63.equals(a62);
        boolean eq63 = a63.equals(a63);
        boolean eq64 = a63.equals(a64);

        boolean eq65 = a63.equals(a65);
        boolean eq66 = a63.equals(a66);
        boolean eq67 = a63.equals(a67);
        boolean eq68 = a63.equals(a68);
        boolean eq69 = a63.equals(a69);
        boolean eq70 = ((a63.equals(a69))==a69.equals(a63));
        boolean eq71 = a69.equals(a63);


        assertFalse(eq0);
        assertFalse(eq1);
        assertFalse(eq2);
        assertFalse(eq3);
        assertFalse(eq4);
        assertFalse(eq5);
        assertFalse(eq6);
        assertFalse(eq7);
        assertFalse(eq8);
        assertFalse(eq9);
        assertFalse(eq10);
        assertFalse(eq11);
        assertFalse(eq12);
        assertFalse(eq13);
        assertFalse(eq14);
        assertFalse(eq15);
        assertFalse(eq16);
        assertFalse(eq17);
        assertFalse(eq18);
        assertFalse(eq19);
        assertFalse(eq20);
        assertFalse(eq21);
        assertFalse(eq22);
        assertFalse(eq23);
        assertFalse(eq24);
        assertFalse(eq25);
        assertFalse(eq26);
        assertFalse(eq27);
        assertFalse(eq28);
        assertFalse(eq29);
        assertFalse(eq30);
        assertFalse(eq31);
        assertFalse(eq32);
        assertFalse(eq33);
        assertFalse(eq34);
        assertFalse(eq35);
        assertFalse(eq36);
        assertFalse(eq37);
        assertFalse(eq38);
        assertFalse(eq39);
        assertFalse(eq40);
        assertFalse(eq41);
        assertFalse(eq42);
        assertFalse(eq43);
        assertFalse(eq44);
        assertFalse(eq45);
        assertFalse(eq46);
        assertFalse(eq47);
        assertFalse(eq48);
        assertFalse(eq49);
        assertFalse(eq50);
        assertFalse(eq51);
        assertFalse(eq52);
        assertFalse(eq53);
        assertFalse(eq54);
        assertFalse(eq55);
        assertFalse(eq56);
        assertFalse(eq57);
        assertFalse(eq58);
        assertFalse(eq59);
        assertFalse(eq60);
        assertFalse(eq61);
        assertTrue(eq62);
        assertTrue(eq63);
        assertTrue(eq64);

        assertFalse(eq65);
        assertFalse(eq66);
        assertFalse(eq67);
        assertFalse(eq68);
        assertFalse(eq69);
        assertTrue(eq70);
        assertFalse(eq71);



    }
}
