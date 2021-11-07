package e1;

@SuppressWarnings("unused")

public class Staff extends Member<Void> {

    enum Subject {Defence, Transfiguration, Potions, Herbology, History}

    <DATA> void reward(Member<DATA> mem) {
        if (mem.category == Category.Teacher) {
            mem.Reward = mem.Horcruxes * 50;
            if (mem.getData() == Subject.Defence)
                mem.Reward *= 0.75;
        }
        if (mem.category == Category.Gamekeeper) mem.Reward = mem.Horcruxes * 75;
        if (mem.category == Category.Caretaker) mem.Reward = mem.Horcruxes * 65;
    }
}
