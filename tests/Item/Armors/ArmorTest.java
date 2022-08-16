package Item.Armors;

import Hero.Mage;
import Item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    public void checkArmor_Armor_ReturnsCorrectArmor() {
        Armor armor = new Armor();
        Item returned = armor.checkArmor("cloth");
        assertTrue(returned instanceof Cloth);
    }

    @Test
    public void checkArmor_Armor_ReturnsNullWhenNotCorrect() {
        Armor armor = new Armor();
        Item returned = armor.checkArmor("ploth");
        assertEquals(null, returned);
    }

    @Test
    public void checkTypeArmor_Boolean_TrueIfMatchOk() {
        Armor armor = new Armor();
        assertTrue(armor.checkTypeArmor("cloth", "mage"));
    }

    @Test
    public void checkTypeArmor_Boolean_FalseIfMatchNotOk() {
        Armor armor = new Armor();
        assertFalse(armor.checkTypeArmor("plate", "mage"));
    }
}