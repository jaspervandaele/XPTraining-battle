package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void Soldier_mustHaveBareFist_ByDefault(){
        Soldier soldier = new Soldier("Jasper");
        assertThat(soldier.getWeapon()).isEqualTo(Weapon.BARE_FIST);
    }

    @Test
    public void attackWithEqualWeaponThenAttackerWins(){
        Soldier soldierAttacker = new Soldier("Jasper");
        Soldier soldierGiuseppe = new Soldier("Giuseppe");

        assertThat(soldierAttacker.attack(soldierGiuseppe)).isEqualTo(soldierAttacker);
    }

    @Test
    public void attackWithBetterWeaponThenAttackerWins(){
        Soldier soldierAttacker = new Soldier("Jasper", Weapon.SPEAR);
        Soldier soldierGiuseppe = new Soldier("Giuseppe");

        assertThat(soldierAttacker.attack(soldierGiuseppe)).isEqualTo(soldierAttacker);
    }

    @Test
    public void attackWithWeakerWeaponThenAttackerWins(){
        Soldier soldierAttacker = new Soldier("Jasper");
        Soldier soldierGiuseppe = new Soldier("Giuseppe",Weapon.AXE);

        assertThat(soldierAttacker.attack(soldierGiuseppe)).isEqualTo(soldierGiuseppe);
    }



}