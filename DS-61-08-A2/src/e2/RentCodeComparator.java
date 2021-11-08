package e2;

import java.util.Comparator;

class RentCodeComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        int code1 = o1.getRent_code();
        int code2 = o2.getRent_code();
        return (code1 - code2);
    }
}