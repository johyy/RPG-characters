package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Axe axe = new Axe();
        double expectedDPS = 2;
        double actualDPS = axe.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}