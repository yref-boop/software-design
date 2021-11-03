package e1;

import static e1.Member.Category;
import static e1.Resident.House;
import static e1.Staff.Subject;

@SuppressWarnings({"rawtypes", "unused"})
public class School {
    public static Member[] Members = new Member[100];
    public static int last = 0;

    public static String printRewards () {

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

    public static String printSalaries () {

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

    public static void newStudent(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Student, horcruxes, house);
    }

    public static void newGhost(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Ghost, horcruxes, house);
    }

    public static void newTeacher(String name, String surname, Subject subject, int horcruxes) {
        newMember(name, surname, Category.Teacher, horcruxes, subject);
    }

    public static void newCareTaker(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Caretaker, horcruxes, null);
    }

    public static void newGamekeeper(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Gamekeeper, horcruxes, null);
    }

    public static <data> void newMember (String name, String surname, Category category, int horcruxes, data d) {
        Member mem = new Member();
        Members[last] = Member.mewMember(name, surname, category, horcruxes, d, mem);
        last ++;
    }
}