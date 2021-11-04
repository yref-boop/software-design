package e2;

import java.util.ArrayList;
import java.util.List;

//class implements Comparator/Comparable +(implement)
public class Manager {
        List<Apartment> apartment = new ArrayList<Apartment>();

        Comparator<Apartment> bp_comparator = new BasePriceComparator();
        Comparator<Apartment> rc_comparator = new RentCodeComparator();
        Comparator<Apartment> fc_comparator = new FullPriceComparator();

}
