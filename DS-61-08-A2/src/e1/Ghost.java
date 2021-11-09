package e1;

public class Ghost extends Resident {

    House Hou;

    public Ghost(String name, String surname, String house, int horcruxes) {
        //pass every value through the constructor
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        Hou = House.valueOf(house);
        category = Category.Ghost;
    }

    //gets the category string for the print functions
    @Override
    String getCategory() { return category.toString() + " of " + Hou.toString() + " "; }

    //gets the reward double fo the print functions
    @Override
    double getReward() {
        double r = Horcruxes * 80;

        if (Hou == House.Slytherin) r *= 2;

        return r;
    }
}
