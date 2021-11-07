package e1;

@SuppressWarnings("unused")
public class Resident extends Member<Void> {

    public enum House {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

    public <DATA> void reward(Member<DATA> mem) {
        if (mem.category == Category.Student) {
            mem.Reward = mem.Horcruxes * 90;
            if (mem.getData() == House.Slytherin)
                mem.Reward *= 2;
        }

        if (mem.category == Category.Ghost) {
            mem.Reward = mem.Horcruxes * 80;
            if (mem.getData() == House.Slytherin)
                mem.Reward *= 2;
        }
    }
}
