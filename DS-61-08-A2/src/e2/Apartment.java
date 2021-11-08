package e2;

class Apartment {
    //attributes:
    private int rent_code;
    private int base_price;
    private int parking_spaces;
    private int pos_code;
    private int parking_price;
    private int full_price;
    private int size;


    //constructor:
    public Apartment(int rent, int base, int parking, int pos, int p_price, int sqrmt) {
        rent_code = rent;
        base_price = base;
        parking_spaces = parking;
        parking_price = p_price;
        pos_code = pos;
        full_price = base + p_price * parking;
        size = sqrmt;
    }

    public Apartment() {}

    //getters:
    public int getRent_code() {return rent_code;}
    public int getBase_price() {return base_price;}
    public int getParking_spaces() {return parking_spaces;}
    public int getPos_code() {return pos_code;}
    public int getFull_price() {return full_price;}
    public int getParking_price() {return parking_price;}
    public int getSize() {return size;}

    //setters:
    public void setRent_code(int rent) {this.rent_code = rent;}
    public void setBase_price(int base_price) {this.base_price = base_price;}
    public void setParking_spaces(int parking_spaces) {this.parking_spaces = parking_spaces;}
    public void setPos_code(int pos_code) {this.pos_code = pos_code;}
    public void setSize(int size) {this.size = size;}
    public void setParking_price(int parking_price) {this.parking_price = parking_price;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}
        if (this.getClass() != o.getClass()) {return false;}

        return (this.base_price == ((Apartment) o).base_price) && (this.parking_spaces == ((Apartment) o).parking_spaces) &&
                (this.pos_code == ((Apartment) o).pos_code) && (this.parking_price == ((Apartment) o).parking_price) &&
                (this.size == ((Apartment) o).size);
    }


    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash + 31 * this.pos_code;
        hash = hash + 31 * this.size;
        hash = hash + 31 * this.base_price;
        hash = hash + 31 * this.parking_spaces;
        hash = hash + 31 * this.parking_price;
        hash = hash + 31 * this.full_price;
        return hash;
    }

}