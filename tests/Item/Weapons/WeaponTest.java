package Item.Weapons;

import Item.Armors.Armor;
import Item.Armors.Cloth;
import Item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    public void checkWeapon_Weapon_ReturnsCorrectArmor() {
        Weapon weapon = new Weapon();
        Item returned = weapon.checkWeapon("axe");
        assertTrue(returned instanceof Axe);
    }

    @Test
    public void checkWeapon_Weapon_ReturnsNullWhenNotCorrect() {
        Weapon weapon = new Weapon();
        Item returned = weapon.checkWeapon("exa");
        assertEquals(null, returned);
    }

    @Test
    public void checkTypeWeapon_Boolean_TrueIfMatchOk() {
        Weapon weapon = new Weapon();
        assertTrue(weapon.checkTypeWeapon("staff", "mage"));
    }

    @Test
    public void checkTypeWeapon_Boolean_FalseIfMatchNotOk() {
        Weapon weapon = new Weapon();
        assertFalse(weapon.checkTypeWeapon("axe", "mage"));
    }
}