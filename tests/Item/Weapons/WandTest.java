package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WandTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Wand wand = new Wand();
        double expectedDPS = 5;
        double actualDPS = wand.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}