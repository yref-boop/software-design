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

interface Comparable<T>{
    public int compareTo(T o);
}

interface Comparator<T>{
    public int compare(T o1, T o2);
}


public class Apartment implements Comparator<Apartment>, Comparable<Apartment> {
    //attributes:
    public int rent_code;
    public int base_price;
    public int parking_spaces;
    public int pos_code;

    //constructors:
    public Apartment(int rent, int base, int parking, int pos) {
        rent_code = rent;
        base_price = base;
        parking_spaces = parking;
        pos_code = pos;
    }

    //methods:

    @Override
    public int compareTo(Apartment o){
        int first = this.getRent_code();
        int second = o.getRent_code();

        if (first < second) return -1;
        if (second < first) return 1;
        else return 0;
    }

    @Override
    public int compare(Apartment o1, Apartment o2){
        int code1= o1.getRent_code();
        int code2= o2.getRent_code();
        //integers take value 0 if not initialized()
        if (code1 == 0) {
            return code2 == 0 ? 0 : 1;
        }
        if (code2 == 0) {
            return -1;
        }
        return o1.compareTo(o2);
    }

    //[].compareTo([])


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

    //setters:
    public void setRent_code(int rent){
        this.rent_code = rent;
    }
    public void setBase_price(int base_price) {
        this.base_price = base_price;
    }
    public void setParking_spaces(int parking_spaces) {
        this.parking_spaces = parking_spaces;
    }
    public void setPos_code(int pos_code) {
        this.pos_code = pos_code;
    }

}
