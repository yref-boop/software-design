package e1;

@SuppressWarnings({"rawtypes", "unused"})
public class Resident extends Member {

    public enum House {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

    public void reward(Member mem) {
        if (mem.category == Category.Student) {
            mem.Reward = mem.Horcruxes * 90;
            if (mem.Data == House.Slytherin)
                mem.Reward *= 2;
        }

        if (mem.category == Category.Ghost) {
            mem.Reward = mem.Horcruxes * 80;
            if (mem.Data == House.Slytherin)
                mem.Reward *= 2;
        }
    }
}
