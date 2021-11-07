package e2;

import java.util.Comparator;

class FullPriceComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        int code1 = o1.getFull_price();
        int code2 = o2.getFull_price();

        if (code1 != code2) {return (code1 - code2);}
        return 0;
    }
}