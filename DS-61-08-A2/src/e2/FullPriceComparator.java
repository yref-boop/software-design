package e2;

import java.util.Comparator;

class FullPriceComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        if((o1 == null)||(o2==null))
            throw new NullPointerException();
        int code1 = o1.getFull_price();
        int code2 = o2.getFull_price();
        return (code1 - code2);
    }
}