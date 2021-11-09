package e1;

public class Teacher extends Staff {

    Subject Sub;

    public Teacher(String name, String surname, String subject, int horcruxes) {
        //pass every value through the constructor
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        Sub = Subject.valueOf(subject);
        category = Category.Teacher;
    }

    //gets the category string for the print functions
    @Override
    String getCategory() {
        return category.toString() + " of " + Sub.toString() + " ";
    }

    //gets the reward double fo the print functions
    @Override
    double getReward() {
        double r = Horcruxes * 50;

        if (Sub == Subject.Defence)  r *= 0.75;

        return r;
    }
}
