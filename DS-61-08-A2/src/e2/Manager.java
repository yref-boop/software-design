package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Manager{

    //attributes
    ArrayList<Apartment> apartments;
    public Comparator<Apartment> comparator;


    //constructor:
    public Manager (ArrayList<Apartment> list, Comparator<Apartment> cmp){
        apartments = list; comparator = cmp;
    }

    //getters
    public Comparator<Apartment> getComparator() {return comparator;}
    public ArrayList<Apartment> getApartments() {return apartments;}

    //setters
    public void setApartments(ArrayList<Apartment> apartments) {this.apartments = apartments;}
    public void setComparator(Comparator<Apartment> comparator) {this.comparator = comparator;}

    //method that sorts the apartments according to current data
    public void sortApartments (){
        Comparator<Apartment> cmp = comparator;
        if(comparator == null){cmp = new RentCodeComparator();}
        Collections.sort(apartments, cmp); //equivalent to apartments.sort(cmp)
    }

}