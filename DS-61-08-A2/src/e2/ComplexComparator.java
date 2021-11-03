package e2;
import java.util.Comparator;

public class ComplexComparator implements Comparator<Apartment>{

    private Comparator<Apartment> comparatorOne;
    private Comparator<Apartment> comparatorTwo;
    private boolean orderOneAscending = true;
    private boolean orderTwoAscending = true;

    public ComplexComparator(Comparator<Apartment> one, boolean orderOneAscending,
                             Comparator<Apartment> another, boolean orderTwoAscending){
            this.comparatorOne = one;
            this.comparatorTwo = another;
            this.orderOneAscending = orderOneAscending;
            this. orderTwoAscending = orderTwoAscending;
    }

    @Override
    public int compare (Apartment one, Apartment another){
        int comparisonByOne;
        int comparisonByAnother;

        if(orderOneAscending){
            comparisonByOne = comparatorOne.compare(another, one);
        } else
            comparisonByOne = comparatorOne.compare(another, one);

        if(orderTwoAscending){
            comparisonByAnother = comparatorTwo.compare(another, one);
        } else
            comparisonByAnother = comparatorTwo.compare(another, one);

        if(comparisonByOne == 0){
            return comparisonByAnother;
        } else
            return comparisonByOne;
    }
}
