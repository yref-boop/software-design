package e1;

@SuppressWarnings("rawtypes")
public class Member<Data> {

    public enum Category {Student, Ghost, Teacher, Gamekeeper, Caretaker}

    public String Name;
    public String Surname;
    public int Horcruxes;
    public double Reward;
    public Category category;
    public Data Data;


    public static <data> Member mewMember(String name, String surname, Category category, int horcruxes, data d, Member mem) {
        mem.Name = name;
        mem.Surname = surname;
        mem.category = category;
        mem.Horcruxes = horcruxes;
        mem.Data = d;

        switch (category) {
            case Student, Ghost -> {
                Resident res = new Resident();
                res.reward(mem);
            }
            case Teacher, Gamekeeper, Caretaker -> {
                Staff sta = new Staff();
                sta.reward(mem);
            }
        }
        return mem;
    }

    public String name() { return Name; }

    public String surname() { return Surname; }

    public String category() {
        switch (category) {
            case Student, Ghost, Teacher -> { return category + " of " + Data + " "; }
            case Gamekeeper, Caretaker -> { return category + " "; }
            default -> { return "[error]"; }
        }
    }

    public int horcruxes() { return Horcruxes; }

    public double getReward() { return Reward; }
}