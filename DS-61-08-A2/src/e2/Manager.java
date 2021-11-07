package e2;

import java.util.ArrayList;
import java.util.Comparator;

class Manager{

    //attributes
    ArrayList<Apartment> apartments;
    public Comparator<Apartment> comparator;

    //getters
    public Comparator<Apartment> getComparator() {return comparator;}
    public ArrayList<Apartment> getApartments() {return apartments;}

    //setters
    public void setApartments(ArrayList<Apartment> apartments) {this.apartments = apartments;}
    public void setComparator(Comparator<Apartment> comparator) {this.comparator = comparator;}

    //constructor:
    public Manager (ArrayList<Apartment> list, Comparator<Apartment> cmp){
        apartments = list;
        comparator = cmp;
    }

    //method that sorts the apartments according to current data
    public void sortApartments (){
        if(comparator == null){comparator = new RentCodeComparator();}
        apartments.sort(comparator);
    }

    //method to print the whole list
    public void printList(){
        apartments.forEach(System.out::println);
    }
}