package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers = new ArrayList<>();

    public Army(Soldier frontMan) {
        soldiers.add(frontMan);
    }

    public Soldier getFrontMan() {
        return soldiers.get(0);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers .add(soldier);
    }

    public Army attack(Army opponent) {
        Soldier winner = getFrontMan().attack(opponent.getFrontMan());
        Army loser = soldiers.contains(winner) ? opponent : this;
        loser.loseFrontMan();
        if(loser.isDead()){
            return this;
        }
        if(this.isDead()){
            return opponent;
        }
        return attack(opponent);
    }

    private boolean isDead() {
        return soldiers.isEmpty();
    }

    private void loseFrontMan() {
        soldiers.remove(getFrontMan());
    }
}
