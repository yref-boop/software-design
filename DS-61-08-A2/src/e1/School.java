package e1;

import static e1.Member.Category;
import static e1.Resident.House;
import static e1.Staff.Subject;

public class School {
    static Member[] Members = new Member[100];
    static int last = 0;

    String printRewards () {

        double galleons = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < last; i++) {

            output.append(Members[i].name()).append(" ").append(Members[i].surname()).append("(")
                    .append(Members[i].category()).append(",").append(Members[i].horcruxes())
                    .append(" horcruxes): ").append(Members[i].getReward()).append(" galleons\n");

            galleons += Members[i].getReward();
        }

        output.append("The total reward for Hogwarts School is ").append(galleons).append(" galleons\n");

        return output.toString();
    }

    String printSalaries () {

        int galleons = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < last; i++) {
            switch (Members[i].category) {
                case Teacher, Gamekeeper, Caretaker -> {

                    output.append(Members[i].name()).append(" ").append(Members[i].surname())
                            .append("(").append(Members[i].category()).append("): ")
                            .append((int)Members[i].getReward()).append(" galleons\n");
                    galleons += Members[i].getReward();
                }
            }
        }
        output.append("The total payroll for Hogwarts School is ").append(galleons).append(" galleons\n");

        return output.toString();
    }

    public void newStudent(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Student, horcruxes, house);
    }

    public void newGhost(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Ghost, horcruxes, house);
    }

    public void newTeacher(String name, String surname, Subject subject, int horcruxes) {
        newMember(name, surname, Category.Teacher, horcruxes, subject);
    }

    public void newCareTaker(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Caretaker, horcruxes, null);
    }

    public void newGamekeeper(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Gamekeeper, horcruxes, null);
    }

    private <DATA> void newMember (String name, String surname, Category category, int horcruxes, DATA d) {
        Member<DATA> mem = new Member<>();
        Members[last] = Member.mewMember(name, surname, category, horcruxes, d, mem);
        last ++;
    }
}