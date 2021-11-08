package e1;

public class Student extends Resident {

    House Hou;

    public Student(String name, String surname, String house, int horcruxes) {
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        Hou = House.valueOf(house);
        category = Category.Student;
    }

    @Override
    String getCategory() { return category.toString() + " of " + Hou.toString() + " "; }

    @Override
    double getReward() {
        int r = Horcruxes * 90;

        if (Hou == House.Slytherin) r *= 2;

        return r;
    }
}
