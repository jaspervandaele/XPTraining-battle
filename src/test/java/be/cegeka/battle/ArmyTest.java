package be.cegeka.battle;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
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

    @Test
    public void attack_singleSoldierArmies_StongestFrontmanWins(){
        Army blackAramy = new Army(new Soldier("Jef", Weapon.AXE));
        Army whiteAramy = new Army(new Soldier("Jules", Weapon.BARE_FIST));

        assertThat(blackAramy.attack(whiteAramy)).isEqualTo(blackAramy);
    }

    @Test
    public void attack_largeSoldierArmies_lastManStandingWins(){
        Army blackAramy = createArmy(Weapon.SPEAR,Weapon.AXE);
        Army whiteAramy = createArmy(Weapon.BARE_FIST, Weapon.AXE, Weapon.SPEAR);

        assertThat(blackAramy.attack(whiteAramy)).isEqualTo(blackAramy);
    }

    private Army createArmy(Weapon... weapons){
        Army army = new Army(new Soldier("x", weapons[0]));
        List<Weapon> weaponList = new ArrayList<>(asList(weapons));
        weaponList.remove(weaponList.get(0));
        for(Weapon w : weaponList){
            army.add(new Soldier("y",w));
        }
        return army;
    }


}
