package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static e1.Resident.House;
import static e1.Staff.Subject;

class SchoolTest {

    @Test
    void TestPrintRewards() {
        School school = new School();

        school.newStudent("Hermione","Granger", House.Ravenclaw, 3);
        school.newGhost("Bloody" , "Baron", House.Slytherin, 1);
        school.newGamekeeper("Rubeus", "Hagrid", 2);
        school.newTeacher("Minerva", "McGonagall", Subject.Transfiguration, 1);
        school.newTeacher("Severus", "Snape", Subject.Defence, 2);
        school.newCareTaker("Argus", "Filch", 0);

        String str = school.printRewards();

        assertEquals(school.printRewards(), """
                Hermione Granger(Student of Ravenclaw ,3 horcruxes): 270.0 galleons
                Bloody Baron(Ghost of Slytherin ,1 horcruxes): 160.0 galleons
                Rubeus Hagrid(Gamekeeper ,2 horcruxes): 150.0 galleons
                Minerva McGonagall(Teacher of Transfiguration ,1 horcruxes): 50.0 galleons
                Severus Snape(Teacher of Defence ,2 horcruxes): 75.0 galleons
                Argus Filch(Caretaker ,0 horcruxes): 0.0 galleons
                The total reward for Hogwarts School is 705.0 galleons
                """);
    }

    @Test
    void TestPrintSalaries() {
        School school = new School();

        school.newStudent("Hermione","Granger", House.Ravenclaw, 3);
        school.newGhost("Bloody" , "Baron", House.Slytherin, 1);
        school.newGamekeeper("Rubeus", "Hagrid", 2);
        school.newTeacher("Minerva", "McGonagall", Subject.Transfiguration, 1);
        school.newTeacher("Severus", "Snape", Subject.Defence, 2);
        school.newCareTaker("Argus", "Filch", 0);

        assertEquals(school.printSalaries(), """
                Rubeus Hagrid(Gamekeeper ): 150 galleons
                Minerva McGonagall(Teacher of Transfiguration ): 50 galleons
                Severus Snape(Teacher of Defence ): 75 galleons
                Argus Filch(Caretaker ): 0 galleons
                The total payroll for Hogwarts School is 275 galleons
                """);
    }
}