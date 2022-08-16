package Item.Weapons;

import Item.Item;

public class Axe extends Item {
    public int damage;
    public double attackSpeed;

    public Axe() {
        super.setName("Axe");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(5);
        this.damage = 10;
        this.attackSpeed = 0.2;
    }

    // method returns the calculated weaponDPS
    public double getWeaponDPS() {
        return damage*attackSpeed;
    }
}