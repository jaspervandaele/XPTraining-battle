package be.cegeka.battle;

public enum Weapon{
    BARE_FIST(1),
    AXE(3),
    SWORD(2),
    SPEAR(2);

    Weapon(int damage){
        this.damage=damage;
    }

    private int damage;

    public int getDamage() {
        return damage;
    }



}
