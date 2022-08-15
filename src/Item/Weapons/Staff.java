package Item.Weapons;

import Item.Item;

public class Staff extends Item {
    public int damage;
    public int attackSpeed;

    public Staff() {
        super.setName("Staff");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(2);
        this.damage = 8;
        this.attackSpeed = 1;
    }

    // method returns the calculated weaponDPS
    public int getWeaponDPS() {
        return damage+attackSpeed;
    }
}
