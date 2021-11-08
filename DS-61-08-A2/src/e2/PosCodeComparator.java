package e2;

import java.util.Comparator;

class PosCodeComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        int code1 = o1.getPos_code();
        int code2 = o2.getPos_code();
        return (code1 - code2);
    }
}