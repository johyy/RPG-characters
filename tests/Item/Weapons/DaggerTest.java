package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Dagger dagger = new Dagger();
        double expectedDPS = 5;
        double actualDPS = dagger.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}