package e1;

@SuppressWarnings({"rawtypes", "unused"})
public class Staff extends Member {

    public enum Subject {Defence, Transfiguration, Potions, Herbology, History}

    public void reward(Member mem) {
        if (mem.category == Category.Teacher) {
            mem.Reward = mem.Horcruxes * 50;
            if (mem.Data == Subject.Defence)
                mem.Reward *= 0.75;
        }
        if (mem.category == Category.Gamekeeper) mem.Reward = mem.Horcruxes * 75;
        if (mem.category == Category.Caretaker) mem.Reward = mem.Horcruxes * 65;
    }
}
