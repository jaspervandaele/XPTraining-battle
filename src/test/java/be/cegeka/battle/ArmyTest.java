package be.cegeka.battle;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmyTest {

    @Test
    public void createArmy_frontManIsFirstEnrolledSoldier() {
        Soldier frontMan = new Soldier("David");
        Army army = new Army(frontMan);

        assertThat(army.getFrontMan()).isEqualTo(frontMan);

    }

    @Test
    public void addSoldier_soldierIsAddedAfterFrontMan() {
        Soldier frontMan = new Soldier("David");
        Soldier mickey = new Soldier("Mickey");
        Army army = new Army(frontMan);
        army.add(mickey);

        Assertions.assertThat(army.getSoldiers()).containsExactly(frontMan,mickey);

    }
}
