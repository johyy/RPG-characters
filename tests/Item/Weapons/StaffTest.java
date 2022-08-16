package Item.Weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    public void getWeaponDPS_DPS_ReturnsDPS() {
        Staff staff = new Staff();
        double expectedDPS = 8;
        double actualDPS = staff.getWeaponDPS();
        assertEquals(expectedDPS, actualDPS);
    }
}