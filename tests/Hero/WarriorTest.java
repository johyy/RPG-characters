package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    public void newRanger_Level_LevelShouldBeOne() {
        Warrior warrior = new Warrior("warrior");
        int expectedLevel = 1;
        int actualLevel = warrior.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void newRanger_PrimaryAttributes_StrengthShouldBeFive() {
        Warrior warrior = new Warrior("warrior");
        double expectedStrength = 5;
        double actualStrength = warrior.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void newRanger_PrimaryAttributes_DexterityShouldBeTwo() {
        Warrior warrior = new Warrior("warrior");
        double expectedDexterity = 2;
        double actualDexterity = warrior.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void newRanger_PrimaryAttributes_IntelligenceShouldBeOne() {
        Warrior warrior = new Warrior("warrior");
        double expectedIntelligence = 1;
        double actualIntelligence = warrior.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void levelUp_Level_ShouldIncreaseToTwo() {
        Warrior warrior = new Warrior("warrior");
        int expectedLevel = 2;
        warrior.levelUp();
        int actualLevel = warrior.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void levelUp_AttributeStrength_ShouldIncreaseToEight() {
        Warrior warrior = new Warrior("warrior");
        double expectedStrength = 8;
        warrior.levelUp();
        double actualStrength = warrior.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void levelUp_AttributeDexterity_ShouldIncreaseToFour() {
        Warrior warrior = new Warrior("warrior");
        double expectedDexterity = 4;
        warrior.levelUp();
        double actualDexterity = warrior.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void levelUp_AttributeIntelligence_ShouldIncreaseToTwo() {
        Warrior warrior = new Warrior("warrior");
        double expectedIntelligence = 2;
        warrior.levelUp();
        double actualIntelligence = warrior.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void dealDamage_LevelPoints_ShouldIncreaseToTen() {
        Warrior warrior = new Warrior("warrior");
        int expectedLevelPoints = 10;
        warrior.dealDamage();
        int actualLevelPoints = warrior.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getWeapon_Typo_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        String expected = "staf didn't match any weapons.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.getWeapon("staf"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongWeapon_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        String expected = "This weapon is not available for warriors.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.getWeapon("staff"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        String expected = "Required level for this weapon is 5.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.getWeapon("axe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeyToItemList() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(5); // required level
        warrior.getWeapon("axe");
        String expectedKey = "Weapon";
        String actualKey = warrior.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeysValueToItemList() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(5); // required level
        warrior.getWeapon("axe");
        String expectedValue = "Axe";
        String key = warrior.itemList.keySet().toArray()[0].toString();
        String actualValue = warrior.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWeapon_LevelPoints_ShouldIncreaseToFive() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        int expectedLevelPoints = 5;
        warrior.setLevel(5); // required level
        warrior.getWeapon("axe");
        int actualLevelPoints = warrior.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getArmor_TypoWithSlot_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        String expected = "Not a suitable slot.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.getArmor("cloth", "toe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_TypoWithArmor_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        String expected = "ploth didn't match any armors.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.getArmor("ploth","head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongArmor_ShouldThrowInvalidArmorExceptionWithProperMessage() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        String expected = "This armor is not available for warriors.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.getArmor("cloth", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        String expected = "Required level for this armor is 6.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.getArmor("mail", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeyToItemList() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(6); // required level
        warrior.getArmor("mail", "head");
        String expectedKey = "head";
        String actualKey = warrior.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeysValueToItemList() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(6); // required level
        warrior.getArmor("mail", "head");
        String expectedValue = "Mail";
        String key = warrior.itemList.keySet().toArray()[0].toString();
        String actualValue = warrior.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getArmor_LevelPoints_ShouldIncreaseToTwo() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        int expectedLevelPoints = 2;
        warrior.setLevel(6); // required level
        warrior.getArmor("mail", "head");
        int actualLevelPoints = warrior.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Warrior warrior = new Warrior("warrior");
        double expectedStrength = warrior.primaryAttribute.getStrength();
        warrior.checkTotalAttributes();
        double actualStrength = warrior.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Warrior warrior = new Warrior("warrior");
        double expectedDexterity = warrior.primaryAttribute.getDexterity();
        warrior.checkTotalAttributes();
        double actualDexterity = warrior.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Warrior warrior = new Warrior("warrior");
        double expectedIntelligence = warrior.primaryAttribute.getIntelligence();
        warrior.checkTotalAttributes();
        double actualIntelligence = warrior.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldIncreaseWithArmorHead() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        double expectedStrength = warrior.primaryAttribute.getStrength()+2;
        warrior.setLevel(6);
        warrior.getArmor("mail", "head");
        warrior.checkTotalAttributes();
        double actualStrength = warrior.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldIncreaseWithArmorHeadAndBody() throws InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        double expectedStrength = warrior.primaryAttribute.getStrength()+2+2;
        warrior.setLevel(6);
        warrior.getArmor("mail", "head");
        warrior.getArmor("mail", "body");
        warrior.checkTotalAttributes();
        double actualStrength = warrior.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkDPS_DPS_WithNoWeapon() {
        Warrior warrior = new Warrior("warrior");
        double expectedDPS = 1*(1+(5/100d));
        warrior.checkDPS();
        double actualDPS = warrior.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeapon() throws InvalidWeaponException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(6);
        warrior.getWeapon("axe");
        double expectedDPS = (10*0.2d)*(1+(5/100d));
        warrior.checkDPS();
        double actualDPS = warrior.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHead() throws InvalidWeaponException, InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(6);
        warrior.getWeapon("axe");
        warrior.getArmor("mail", "head");
        double expectedDPS = (10*0.2d)*(1+((5+2)/100d));
        warrior.checkDPS();
        double actualDPS = warrior.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHeadAndBody() throws InvalidWeaponException, InvalidArmorException {
        Warrior warrior = new Warrior("warrior");
        warrior.setLevel(6);
        warrior.getWeapon("axe");
        warrior.getArmor("mail", "head");
        warrior.getArmor("mail", "body");
        double expectedDPS = (10*0.2)*(1+((5+2+2)/100d));
        warrior.checkDPS();
        double actualDPS = warrior.DPS;

        assertEquals(expectedDPS, actualDPS);
    }
}