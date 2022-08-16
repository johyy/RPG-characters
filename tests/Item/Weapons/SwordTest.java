package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Sword sword = new Sword();
        double expectedDPS = 20;
        double actualDPS = sword.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}