package e1;

//Base class

public class School {

    public static Member[] Members = new Member[100];
    public static int last = 0;
    public enum Category {Student, Ghost, Teacher, Gamekeeper, Caretaker}
    public enum Data {Gryffindor, Hufflepuff, Ravenclaw, Slytherin, Defence, Transfiguration, Potions, Herbology, History, NULL}

    public static void printRewards () {

        double galleons = 0;

        for (int i = 0; i < last; i++) {
            System.out.print(Members[i].name() + " " + Members[i].surname() + "(" + Members[i].category() + " ,"
                    + Members[i].horcruxes() + " horcruxes): " + Members[i].reward() + " galleons\n");
            galleons += Members[i].reward();
        }

        System.out.print("The total reward for Hogwarts School is " + galleons + " galleons\n");
    }

    public static void printSalaries () {

        int galleons = 0;

        for (int i = 0; i < last; i++) {
            if ((Members[i].Category == Category.Teacher) || (Members[i].Category == Category.Gamekeeper) || (Members[i].Category == Category.Caretaker)) {

                System.out.print(Members[i].name() + " " + Members[i].surname() + "(" + Members[i].category()
                                 + "): " + Members[i].reward() + " galleons\n");
                galleons += Members[i].reward();
            }
        }

        System.out.print("The total payroll for Hogwarts School is " + galleons + " galleons\n");
    }

    public static void newMember (String name, String surname, Category category, int horcruxes, Data...data) {
        Member mem = new Member();
        mem.Name = name;
        mem.Surname = surname;
        mem.Category = category;
        mem.Horcruxes = horcruxes;
        if (data.length > 0)
            mem.Data = data[0];
        else
            mem.Data = Data.NULL;

        Members[last] = mem;
        last ++;
    }

    public static void main(String[] args)
    {
        newMember("Hermione","Granger", Category.Student, 3, Data.Gryffindor);
        newMember("Bloody" , "Baron", Category.Ghost, 1, Data.Slytherin);
        newMember("Rubeus", "Hagrid", Category.Gamekeeper, 2);
        newMember("Minerva", "McGonagall", Category.Teacher, 1, Data.Transfiguration);
        newMember("Severus", "Snape", Category.Teacher, 2, Data.Defence);
        newMember("Argus", "Filch", Category.Caretaker, 0);

        printRewards();
        printSalaries();
    }
}