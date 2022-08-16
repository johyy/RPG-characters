package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Bow bow = new Bow();
        double expectedDPS = 10;
        double actualDPS = bow.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}