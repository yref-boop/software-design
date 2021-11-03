package e2;


public interface Comparable<T> {
    @Override
    public int compareTo(Apartment otherApartment) {
        return Integer.compare(this.getRent_code(), otherApartment.getRent_code());
    }
}
