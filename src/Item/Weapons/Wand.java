package Item.Weapons;

import Item.Item;

public class Wand extends Item {
    public int damage;
    public double attackSpeed;

    public Wand() {
        super.setName("Wand");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(5);
        this.damage = 10;
        this.attackSpeed = 0.5;
    }

    // method returns the calculated weaponDPS
    public double getWeaponDPS() {
        return damage*attackSpeed;
    }
}


