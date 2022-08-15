package Item.Weapons;

import Item.Item;

public class Bow extends Item {
    public int damage;
    public int attackSpeed;

    public Bow() {
        super.setName("Bow");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(1);
        this.damage = 10;
        this.attackSpeed = 1;
    }

    // method returns the calculated weaponDPS
    public int getWeaponDPS() {
        return damage+attackSpeed;
    }
}
