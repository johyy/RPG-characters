package Item.Weapons;

import Item.Item;

public class Sword extends Item {
    public int damage;
    public int attackSpeed;

    public Sword() {
        super.setName("Sword");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(10);
        this.damage = 10;
        this.attackSpeed = 2;
    }

    // method returns the calculated weaponDPS
    public int getWeaponDPS() {
        return damage*attackSpeed;
    }
}