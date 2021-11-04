package e2;


class BasePriceComparator implements Comparator<Apartment>{

    @Override
    public int compare(Apartment o1, Apartment o2){
        int code1= o1.getBase_price();
        int code2= o2.getBase_price();
        //integers take value 0 if not initialized()
        if (code1 == 0) {
            return code2 == 0 ? 0 : 1;
        }
        if (code2 == 0) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}

class RentCodeComparator implements Comparator<Apartment>{

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
}

class FullPriceComparator implements Comparator<Apartment>{

    @Override
    public int compare(Apartment o1, Apartment o2){
        int code1= o1.getFull_price();
        int code2= o2.getFull_price();
        //integers take value 0 if not initialized()
        if (code1 == 0) {
            return code2 == 0 ? 0 : 1;
        }
        if (code2 == 0) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}


//List myList = new ArrayList();