package be.cegeka.battle;

import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Soldier {

    private final String name;
    private Weapon weapon;

    public Soldier(String name) {
        this(name,Weapon.BARE_FIST);
    }

    public Soldier(String name, Weapon weapon) {
        Validate.isTrue(isNotBlank(name));
        this.weapon = weapon;
        this.name = name;

    }

    String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Soldier attack(Soldier oponent) {
        if(winsFrom(oponent)){
            return this;
        }
        return oponent;
    }

    public boolean winsFrom(Soldier oponent){
        return  weapon.getDamage() >= oponent.getWeapon().getDamage();
    }
}
