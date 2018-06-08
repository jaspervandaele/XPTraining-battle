package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private Soldier frontMan;
    private List<Soldier> soldiers = new ArrayList<>();

    public Army(Soldier frontMan) {
        this.frontMan = frontMan;
        soldiers.add(frontMan);
    }

    public Soldier getFrontMan() {
        return frontMan;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers .add(soldier);
    }
}
