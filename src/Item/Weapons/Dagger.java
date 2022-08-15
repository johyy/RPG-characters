package Item.Weapons;

import Item.Item;

public class Dagger extends Item {
    public int damage;
    public int attackSpeed;

    public Dagger() {
        super.setName("Dagger");
        super.setItemSlot("Weapon");
        super.setRequiredLevel(2);
        this.damage = 5;
        this.attackSpeed = 1;

    }

    // method returns the calculated weaponDPS
    public int getWeaponDPS() {
        return damage+attackSpeed;
    }
}
