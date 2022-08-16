package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    public void newMage_Level_LevelShouldBeOne() {
        Mage mage = new Mage("mage");
        int expectedLevel = 1;
        int actualLevel = mage.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void newMage_PrimaryAttributes_StrengthShouldBeOne() {
        Mage mage = new Mage("mage");
        double expectedStrength = 1;
        double actualStrength = mage.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void newMage_PrimaryAttributes_DexterityShouldBeOne() {
        Mage mage = new Mage("mage");
        double expectedDexterity = 1;
        double actualDexterity = mage.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void newMage_PrimaryAttributes_IntelligenceShouldBeEight() {
        Mage mage = new Mage("mage");
        double expectedIntelligence = 8;
        double actualIntelligence = mage.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void levelUp_Level_ShouldIncreaseToTwo() {
        Mage mage = new Mage("mage");
        int expectedLevel = 2;
        mage.levelUp();
        int actualLevel = mage.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void levelUp_AttributeStrength_ShouldIncreaseToTwo() {
        Mage mage = new Mage("mage");
        double expectedStrength = 2;
        mage.levelUp();
        double actualStrength = mage.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void levelUp_AttributeDexterity_ShouldIncreaseToTwo() {
        Mage mage = new Mage("mage");
        double expectedDexterity = 2;
        mage.levelUp();
        double actualDexterity = mage.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void levelUp_AttributeIntelligence_ShouldIncreaseToThirteen() {
        Mage mage = new Mage("mage");
        double expectedIntelligence = 13;
        mage.levelUp();
        double actualIntelligence = mage.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void dealDamage_LevelPoints_ShouldIncreaseToTen() {
        Mage mage = new Mage("mage");
        int expectedLevelPoints = 10;
        mage.dealDamage();
        int actualLevelPoints = mage.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getWeapon_Typo_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        String expected = "staf didn't match any weapons.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> mage.getWeapon("staf"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongWeapon_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        String expected = "This weapon is not available for mages.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> mage.getWeapon("axe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        String expected = "Required level for this weapon is 2.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> mage.getWeapon("staff"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeyToItemList() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        mage.setLevel(2); // required level
        mage.getWeapon("staff");
        String expectedKey = "Weapon";
        String actualKey = mage.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeysValueToItemList() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        mage.setLevel(2); // required level
        mage.getWeapon("staff");
        String expectedValue = "Staff";
        String key = mage.itemList.keySet().toArray()[0].toString();
        String actualValue = mage.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWeapon_LevelPoints_ShouldIncreaseToFive() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        int expectedLevelPoints = 5;
        mage.setLevel(2); // required level
        mage.getWeapon("staff");
        int actualLevelPoints = mage.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getArmor_TypoWithSlot_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        String expected = "Not a suitable slot.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> mage.getArmor("cloth", "toe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_TypoWithArmor_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        String expected = "ploth didn't match any armors.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> mage.getArmor("ploth","head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongArmor_ShouldThrowInvalidArmorExceptionWithProperMessage() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        String expected = "This armor is not available for mages.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> mage.getArmor("plate", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        String expected = "Required level for this armor is 2.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> mage.getArmor("cloth", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeyToItemList() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        mage.setLevel(2); // required level
        mage.getArmor("cloth", "head");
        String expectedKey = "head";
        String actualKey = mage.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeysValueToItemList() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        mage.setLevel(2); // required level
        mage.getArmor("cloth", "head");
        String expectedValue = "Cloth";
        String key = mage.itemList.keySet().toArray()[0].toString();
        String actualValue = mage.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getArmor_LevelPoints_ShouldIncreaseToTwo() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        int expectedLevelPoints = 2;
        mage.setLevel(2); // required level
        mage.getArmor("cloth", "head");
        int actualLevelPoints = mage.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Mage mage = new Mage("mage");
        double expectedStrength = mage.primaryAttribute.getStrength();
        mage.checkTotalAttributes();
        double actualStrength = mage.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Mage mage = new Mage("mage");
        double expectedDexterity = mage.primaryAttribute.getDexterity();
        mage.checkTotalAttributes();
        double actualDexterity = mage.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Mage mage = new Mage("mage");
        double expectedIntelligence = mage.primaryAttribute.getIntelligence();
        mage.checkTotalAttributes();
        double actualIntelligence = mage.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldIncreaseWithArmorHead() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        double expectedIntelligence = mage.primaryAttribute.getIntelligence()+1;
        mage.setLevel(2);
        mage.getArmor("cloth", "head");
        mage.checkTotalAttributes();
        double actualIntelligence = mage.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldIncreaseWithArmorHeadAndBody() throws InvalidArmorException {
        Mage mage = new Mage("mage");
        double expectedIntelligence = mage.primaryAttribute.getIntelligence()+1+1;
        mage.setLevel(2);
        mage.getArmor("cloth", "head");
        mage.getArmor("cloth", "body");
        mage.checkTotalAttributes();
        double actualIntelligence = mage.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkDPS_DPS_WithNoWeapon() {
        Mage mage = new Mage("mage");
        double expectedDPS = 1*(1+(8/100d));
        mage.checkDPS();
        double actualDPS = mage.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeapon() throws InvalidWeaponException {
        Mage mage = new Mage("mage");
        mage.setLevel(2);
        mage.getWeapon("staff");
        double expectedDPS = (8*1)*(1+(8/100d));
        mage.checkDPS();
        double actualDPS = mage.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHead() throws InvalidWeaponException, InvalidArmorException {
        Mage mage = new Mage("mage");
        mage.setLevel(2);
        mage.getWeapon("staff");
        mage.getArmor("cloth", "head");
        double expectedDPS = (8*1)*(1+((8+1)/100d));
        mage.checkDPS();
        double actualDPS = mage.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHeadAndBody() throws InvalidWeaponException, InvalidArmorException {
        Mage mage = new Mage("mage");
        mage.setLevel(2);
        mage.getWeapon("staff");
        mage.getArmor("cloth", "head");
        mage.getArmor("cloth", "body");
        double expectedDPS = (8*1)*(1+((8+1+1)/100d));
        mage.checkDPS();
        double actualDPS = mage.DPS;

        assertEquals(expectedDPS, actualDPS);
    }
}