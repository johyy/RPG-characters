package Item.Weapons;

import Item.Item;

public class Hammer extends Item {
    public int damage;
    public int attackSpeed;

    public Hammer() {
        super.setName("Hammer");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(5);
        this.damage = 4;
        this.attackSpeed = 2;
    }

    // method returns the calculated weaponDPS
    public int getWeaponDPS() {
        return damage*attackSpeed;
    }
}
