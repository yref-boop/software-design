package e2;

//ad: reference number, price: base price+pacrkong space (optional) post code (etc)
//equals and hash code disregaard reference number
//referene number: natural order of comparison

//manager classs: two attributes: list of appartments and criterion of comparison (instance of Comparator)
//(starts null) must be a way of assingn a new value to comparator and another for resorting the apartments

//comparator classes of your own: total price, base, two other

//repeat as wanted

//ABSTRACT METHODS:
//comparable includes method compareTo (T o ), compares object with specified onkect according to "natural order"
//negative: less, 0 =, + >

//comparator: similar to the abobe method compaes pair of object

//collections :
//1: pass a list that implement comparable and sorts the list according to antural
//q: adds a Comparator as an argumwnt and sorts accordign to that

public class Apartment {
    //attributes:
    public int rent_code;
    public int base_price;
    public int parking_spaces;
    public int pos_code;

    //constructors:
    public Apartment(int rent, int base, int parking, int pos){
        rent_code = rent;
        base_price = base;
        parking_spaces= parking;
        pos_code = pos;
    }

    //methods:
    //getters:
    public int getRent_code() {
        return rent_code;
    }

    public int getBase_price() {
        return base_price;
    }

    public int getParking_spaces() {
        return parking_spaces;
    }

    public int getPos_code() {
        return pos_code;
    }
}
