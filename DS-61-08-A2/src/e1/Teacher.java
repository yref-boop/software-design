package e1;

public class Teacher extends Staff {

    Subject Sub;

    public Teacher(String name, String surname, String subject, int horcruxes) {
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        Sub = Subject.valueOf(subject);
        category = Category.Teacher;
    }

    @Override
    String getCategory() {
        return category.toString() + " of " + Sub.toString() + " ";
    }

    @Override
    double getReward() {
        int r = Horcruxes * 50;

        if (Sub == Subject.Defence)  r *= 0.75;

        return r;
    }
}
