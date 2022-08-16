package Hero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void checkLevelPoints_Level_IfOver100LevelUp() {
        Mage mage = new Mage("mage");
        mage.setLevelPoints(100);
        int expectedLevel = 2;
        mage.checkLevelPoints();
        int actualLevel = mage.getLevel();
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    void checkLevelPoints_Level_IfUnder100LevelStays() {
        Mage mage = new Mage("mage");
        mage.setLevelPoints(99);
        int expectedLevel = 1;
        mage.checkLevelPoints();
        int actualLevel = mage.getLevel();
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    void checkLevelPoints_LevelPoints_Over100DropTo0() {
        Mage mage = new Mage("mage");
        mage.setLevelPoints(100);
        int expectedLevelPoints = 0;
        mage.checkLevelPoints();
        int actualLevelPoints = mage.getLevelPoints();
        assertEquals(expectedLevelPoints, actualLevelPoints);
    }
}