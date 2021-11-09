package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static e1.Resident.House;
import static e1.Staff.Subject;

class SchoolTest {

    @Test
    void TestPrintRewards() {
        School school = new School();

        //test normal behaviour of functions new[...]
        school.newStudent("Hermione","Granger", House.Ravenclaw, 3);
        school.newGhost("GhostTest1", "", House.Gryffindor, 5);
        school.newStudent("StudentTest1","Surname", House.Hufflepuff, 3);
        school.newStudent("StudentTest2","Surname", House.Slytherin, 0);
        school.newGhost("Bloody" , "Baron", House.Slytherin, 1);
        school.newGamekeeper("Rubeus", "Hagrid", 2);
        school.newTeacher("Minerva", "McGonagall", Subject.Transfiguration, 1);
        school.newTeacher("Severus", "Snape", Subject.Defence, 2);
        school.newCareTaker("Argus", "Filch", 0);
        school.newTeacher("TeacherTest1", "Surname", Subject.Potions, 3);
        school.newTeacher("TeacherTest2", "Surname", Subject.Herbology, 2);
        school.newTeacher("TeacherTest3", "Surname", Subject.History, 1);

        //test exceptions for a non-valid value of name or horcruxes
        assertThrows(IllegalArgumentException.class, () -> school.newStudent("", "", House.Ravenclaw, 3));
        assertThrows(IllegalArgumentException.class, () -> school.newGamekeeper("Name", "Surname", -1));

        assertEquals(school.printRewards(), """
                Hermione Granger(Student of Ravenclaw ,3 horcruxes): 270.0 galleons
                GhostTest1 (Ghost of Gryffindor ,5 horcruxes): 400.0 galleons
                StudentTest1 Surname(Student of Hufflepuff ,3 horcruxes): 270.0 galleons
                StudentTest2 Surname(Student of Slytherin ,0 horcruxes): 0.0 galleons
                Bloody Baron(Ghost of Slytherin ,1 horcruxes): 160.0 galleons
                Rubeus Hagrid(Gamekeeper ,2 horcruxes): 150.0 galleons
                Minerva McGonagall(Teacher of Transfiguration ,1 horcruxes): 50.0 galleons
                Severus Snape(Teacher of Defence ,2 horcruxes): 75.0 galleons
                Argus Filch(Caretaker ,0 horcruxes): 0.0 galleons
                TeacherTest1 Surname(Teacher of Potions ,3 horcruxes): 150.0 galleons
                TeacherTest2 Surname(Teacher of Herbology ,2 horcruxes): 100.0 galleons
                TeacherTest3 Surname(Teacher of History ,1 horcruxes): 50.0 galleons
                The total reward for Hogwarts School is 1675.0 galleons
                """);

    }

    @Test
    void TestPrintSalaries() {
        School school = new School();

        //test normal behaviour of functions new[...]
        school.newStudent("Hermione","Granger", House.Ravenclaw, 3);
        school.newGhost("GhostTest1", "", House.Gryffindor, 5);
        school.newStudent("StudentTest1","Surname", House.Hufflepuff, 3);
        school.newStudent("StudentTest2","Surname", House.Slytherin, 0);
        school.newGhost("Bloody" , "Baron", House.Slytherin, 1);
        school.newGamekeeper("Rubeus", "Hagrid", 2);
        school.newTeacher("Minerva", "McGonagall", Subject.Transfiguration, 1);
        school.newTeacher("Severus", "Snape", Subject.Defence, 2);
        school.newCareTaker("Argus", "Filch", 0);
        school.newTeacher("TeacherTest1", "Surname", Subject.Potions, 3);
        school.newTeacher("TeacherTest2", "Surname", Subject.Herbology, 2);
        school.newTeacher("TeacherTest3", "Surname", Subject.History, 1);

        //test exceptions for a non-valid value of name or horcruxes
        assertThrows(IllegalArgumentException.class, () -> school.newStudent("", "", House.Ravenclaw, 3));
        assertThrows(IllegalArgumentException.class, () -> school.newGamekeeper("Name", "Surname", -1));

        assertEquals(school.printSalaries(), """
                Rubeus Hagrid(Gamekeeper ): 150 galleons
                Minerva McGonagall(Teacher of Transfiguration ): 50 galleons
                Severus Snape(Teacher of Defence ): 75 galleons
                Argus Filch(Caretaker ): 0 galleons
                TeacherTest1 Surname(Teacher of Potions ): 150 galleons
                TeacherTest2 Surname(Teacher of Herbology ): 100 galleons
                TeacherTest3 Surname(Teacher of History ): 50 galleons
                The total payroll for Hogwarts School is 575 galleons
                """);
    }
}