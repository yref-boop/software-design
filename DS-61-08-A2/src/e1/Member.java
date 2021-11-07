package e1;

public class Member<DATA> {

    public DATA getData() { return Data; }
    public void setData(DATA data) { Data = data; }

    enum Category {Student, Ghost, Teacher, Gamekeeper, Caretaker}

    private String Name;
    private String Surname;
    public int Horcruxes;
    public double Reward;
    public Category category;
    private DATA Data;


    static <DATA> Member<DATA> mewMember(String name, String surname, Category category, int horcruxes, DATA d, Member<DATA> mem) {
        mem.Name = name;
        mem.Surname = surname;
        mem.category = category;
        mem.Horcruxes = horcruxes;
        mem.setData(d);

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

    String name() { return Name; }
    String surname() { return Surname; }
    int horcruxes() { return Horcruxes; }
    double getReward() { return Reward; }

    String category() {
        switch (category) {
            case Student, Ghost, Teacher -> { return category + " of " + getData() + " "; }
            case Gamekeeper, Caretaker -> { return category + " "; }
            default -> { return "[error]"; }
        }
    }
}