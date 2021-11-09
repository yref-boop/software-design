package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static e1.Member.Category;
import static e1.Resident.House;
import static e1.Staff.Subject;

public class School {

    //list of members
    private final List<Member> Members = new ArrayList<>();

    String printRewards () {

        double galleons = 0;
        StringBuilder output = new StringBuilder();

        //go through every value in the list and print accordingly
        for (Member member : Members) {
            output.append(member.getName()).append(" ").append(member.getSurname()).append("(")
                    .append(member.getCategory()).append(",").append(member.getHorcruxes())
                    .append(" horcruxes): ").append(member.getReward()).append(" galleons\n");
            //get the total sum
            galleons += member.getReward();
        }

        output.append("The total reward for Hogwarts School is ").append(galleons).append(" galleons\n");

        return output.toString();
    }

    String printSalaries () {

        int galleons = 0;
        StringBuilder output = new StringBuilder();

        //go through every value in the list and print accordingly
        for (Member member : Members) {
            switch (member.category) {
                case Teacher, Gamekeeper, Caretaker -> {
                    output.append(member.getName()).append(" ").append(member.getSurname())
                            .append("(").append(member.getCategory()).append("): ")
                            .append((int) member.getReward()).append(" galleons\n");
                    //get the total sum
                    galleons += member.getReward();
                }
            }
        }
        output.append("The total payroll for Hogwarts School is ").append(galleons).append(" galleons\n");

        return output.toString();
    }

    //new[...] functions create instances of different types of members with the proper values

    public void newStudent(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Student, horcruxes, house.toString());
    }

    public void newGhost(String name, String surname, House house, int horcruxes) {
        newMember(name, surname, Category.Ghost, horcruxes, house.toString());
    }

    public void newTeacher(String name, String surname, Subject subject, int horcruxes) {
        newMember(name, surname, Category.Teacher, horcruxes, subject.toString());
    }

    public void newCareTaker(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Caretaker, horcruxes, null);
    }

    public void newGamekeeper(String name, String surname, int horcruxes) {
        newMember(name, surname, Category.Gamekeeper, horcruxes, null);
    }

    //general function to create a new member
    private void newMember (String name, String surname, Category category, int horcruxes, String data) {

        //the following conditions check if an exception is met, in the case it throws an IllegalArgumentException
        if (horcruxes < 0 || Objects.equals(name.replaceAll(" ", ""), "")) throw new IllegalArgumentException();

        switch (category) {
            case Student -> Members.add(new Student(name, surname, data, horcruxes));
            case Ghost -> Members.add(new Ghost(name, surname, data, horcruxes));
            case Teacher -> Members.add(new Teacher(name, surname, data, horcruxes));
            case Gamekeeper -> Members.add(new Gamekeeper(name, surname, horcruxes));
            case Caretaker -> Members.add(new Caretaker(name, surname, horcruxes));
        }
    }
}