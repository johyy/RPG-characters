package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammerTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Hammer hammer = new Hammer();
        double expectedDPS = 8;
        double actualDPS = hammer.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}