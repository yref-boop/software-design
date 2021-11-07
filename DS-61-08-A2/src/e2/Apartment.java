package e2;
import e3.NetworkManager;

import java.security.InvalidAlgorithmParameterException;
import java.util.*;
/*
class Comparing {
    static Comparator<Apartment> BasePriceComparator = new Comparator<Apartment>(){
        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getBase_price();
            int code2 = o2.getBase_price();
            //integers take value 0 if not initialized()
            if (code1 != code2) {
                return (code1 - code2);
            }
            return 0;
        }
    };
    static Comparator<Apartment> RentCodeComparator = new Comparator<Apartment>(){
        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getRent_code();
            int code2 = o2.getRent_code();
            //integers take value 0 if not initialized()
            if (code1 != code2) {
                return (code1 - code2);
            }
            return 0;
        }
    };
    static Comparator<Apartment> FullPriceComparator = new Comparator<Apartment>(){
        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getFull_price();
            int code2 = o2.getFull_price();
            //integers take value 0 if not initialized()
            if (code1 != code2) {
                return (code1 - code2);
            }
            return 0;
        }
    };
    static Comparator<Apartment> SizeComparator = new Comparator<Apartment>(){
        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getSize();
            int code2 = o2.getSize();
            //integers take value 0 if not initialized()
            if (code1 != code2) {
                return (code1 - code2);
            }
            return 0;
        }
    };
    static Comparator<Apartment> PosCodeComparator = new Comparator<Apartment>(){
        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getPos_code();
            int code2 = o2.getPos_code();

            if (code1 != code2) {
                return (code1 - code2);
            }
            return 0;
        }
    };
}



class GenericComparing<T> {
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
        public GenericComparing (T value){
            this.value = value;
        }
    }
 */

    class BasePriceComparator implements Comparator<Apartment> {

        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getBase_price();
            int code2 = o2.getBase_price();

            if (code1 != code2) {return (code1 - code2);}
            return 0;
        }
    }

    class RentCodeComparator implements Comparator<Apartment> {

        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getRent_code();
            int code2 = o2.getRent_code();

            if (code1 != code2) {return (code1 - code2);}
            return 0;
        }
    }

    class FullPriceComparator implements Comparator<Apartment> {

        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getFull_price();
            int code2 = o2.getFull_price();

            if (code1 != code2) {return (code1 - code2);}
            return 0;
        }
    }

    class SizeComparator implements Comparator<Apartment> {

        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getSize();
            int code2 = o2.getSize();

            if (code1 != code2) {return (code1 - code2);}
            return 0;
        }
    }

    class PosCodeComparator implements Comparator<Apartment> {

        @Override
        public int compare(Apartment o1, Apartment o2) {
            int code1 = o1.getPos_code();
            int code2 = o2.getPos_code();

            if (code1 != code2) {return (code1 - code2);}
            return 0;
        }
    }


class Apartment {
    //attributes:
    private int rent_code;
    private int base_price;
    private int parking_spaces;
    private int pos_code;
    private int parking_price;
    private int full_price;
    private int size;


    //constructor:
    public Apartment(int rent, int base, int parking, int pos, int p_price, int sqrmt) {
        rent_code = rent;
        base_price = base;
        parking_spaces = parking;
        parking_price = p_price;
        pos_code = pos;
        full_price = rent + p_price * parking;
        size = sqrmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}
        if (this.getClass() != o.getClass()) {return false;}

        return (this.base_price == ((Apartment) o).base_price) && (this.parking_spaces == ((Apartment) o).parking_spaces) &&
                (this.pos_code == ((Apartment) o).pos_code) && (this.parking_price == ((Apartment) o).parking_price) &&
                (this.size == ((Apartment) o).size);
    }


    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash + 31 * this.pos_code;
        hash = hash + 31 * this.size;
        hash = hash + 31 * this.base_price;
        hash = hash + 31 * this.parking_spaces;
        hash = hash + 31 * this.parking_price;
        hash = hash + 31 * this.full_price;
        return hash;
    }


    //getters:
    public int getRent_code() {return rent_code;}
    public int getBase_price() {return base_price;}
    public int getParking_spaces() {return parking_spaces;}
    public int getPos_code() {return pos_code;}
    public int getFull_price() {return full_price;}
    public int getParking_price() {return parking_price;}
    public int getSize() {return size;}


    //setters:
    public void setRent_code(int rent) {this.rent_code = rent;}
    public void setBase_price(int base_price) {this.base_price = base_price;}
    public void setParking_spaces(int parking_spaces) {this.parking_spaces = parking_spaces;}
    public void setPos_code(int pos_code) {this.pos_code = pos_code;}
    public void setFull_price(int full_price) {this.full_price = full_price;}
    public void setSize(int size) {this.size = size;}
    public void setParking_price(int parking_price) {this.parking_price = parking_price;}
}
/*
class listSort{

    public void sort(List<Apartment> list, BasePriceComparator comparator){
        Collections.sort(list, comparator);
    }
    public void sort(List<Apartment> list, FullPriceComparator comparator){
        list.sort(comparator);
    }
    //...

}
*/
    class Manager{
        //atributes
        ArrayList<Apartment> apartments = new ArrayList<>();
        public Comparator<Apartment> comparator;

        //methods:
        //constructor:
        public Manager (ArrayList<Apartment> list, Comparator<Apartment> cmp){
            apartments = list;
            comparator = cmp;
        }

        public void sortApartments (ArrayList<Apartment> apartments, Comparator<Apartment> comparator){
            apartments.sort(comparator);
        }

        /*Arrays.asList(
                new Apartment(0,100,1,7,9,222),
                new Apartment(1,200,4,0,7,234),
                new Apartment(2,400,3,2,3,9),
                new Apartment(3,300,2,1,32,23908)
        ));

         public BasePriceComparator bp_comp = new BasePriceComparator();
         public void sortApartment(Comparator<Apartment> comparator){
             comparator.compare(apartments);
         }

         //sorting=comparator<Apartment>
         //sort=compare

        public int comparator_imp (Apartment a1, Apartment a2){
            return comparator.compare(a1, a2);
        }

        //criterion of comparison (an instance of what is known as a comparator)
        //Comparing comparator = null;

        //this is (?????????) (trying to use generics to implement the criterion of comparison)
        var c_base = new GenericComparing<BasePriceComparator>(new BasePriceComparator());
        var r_code = new GenericComparing<RentCodeComparator>(new RentCodeComparator());
        var f_price = new GenericComparing<FullPriceComparator>(new FullPriceComparator());
        var size = new GenericComparing<SizeComparator>(new SizeComparator());
        var pos_code = new GenericComparing<PosCodeComparator>(new PosCodeComparator());

        //using the class comparing, using Collections.sort
        Collections.sort(apartments, Comparing.BasePriceComparator);
        Collections.sort(apartments, Comparing.RentCodeComparator);
        Collections.sort(apartments, Comparing.FullPriceComparator);
        Collections.sort(apartments, Comparing.SizeComparator);
        Collections.sort(apartments, Comparing.PosCodeComparator);

        //using individual classes, using List.sort
        apartments.sort(new RentCodeComparator());
        apartments.sort(new FullPriceComparator());
        apartments.sort(new SizeComparator());
        apartments.sort(new PosCodeComparator());
*/
}


