package e2;

import java.util.Comparator;

class SizeComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        if((o1 == null)||(o2==null))
            throw new NullPointerException();
        int code1 = o1.getSize();
        int code2 = o2.getSize();
        return (code1 - code2);

    }
}