package e1;

public class Member {

    public String Name;
    public String Surname;
    public School.Data Data;
    public School.Category Category;
    public int Horcruxes;
    public double Reward;

    public String name() { return Name; }

    public String surname() { return Surname; }

    public String category() {

        if ((Category == School.Category.Student) || (Category == School.Category.Ghost))
            return Category.toString() + " of " + Data;
        else if ((Category == School.Category.Gamekeeper) || (Category == School.Category.Caretaker))
            return Category.toString();
        else if (Category == School.Category.Teacher)
            return Category.toString() + " of " + Data;
        else
            return "[error]";
    }

    public int horcruxes() { return Horcruxes; }

    public double reward() {

        if (Category == School.Category.Teacher) {
            Reward = Horcruxes * 50;
            if (Data == School.Data.Defence)
                Reward = Reward * 0.75;
        }

        if (Category == School.Category.Caretaker)
            Reward = Horcruxes * 65;

        if (Category == School.Category.Gamekeeper)
            Reward = Horcruxes * 75;

        if (Category == School.Category.Ghost) {
            Reward = Horcruxes * 80;
            if (Data == School.Data.Slytherin)
                Reward *= 2;
        }

        if (Category == School.Category.Student) {
            Reward = Horcruxes * 90;
            if (Data == School.Data.Slytherin)
                Reward *= 2;
        }
        return Reward;
    }
}