package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    @Test
    public void newRanger_Level_LevelShouldBeOne() {
        Rogue rogue = new Rogue("rogue");
        int expectedLevel = 1;
        int actualLevel = rogue.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void newRanger_PrimaryAttributes_StrengthShouldBeTwo() {
        Rogue rogue = new Rogue("rogue");
        double expectedStrength = 2;
        double actualStrength = rogue.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void newRanger_PrimaryAttributes_DexterityShouldBeSix() {
        Rogue rogue = new Rogue("rogue");
        double expectedDexterity = 6;
        double actualDexterity = rogue.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void newRanger_PrimaryAttributes_IntelligenceShouldBeOne() {
        Rogue rogue = new Rogue("rogue");
        double expectedIntelligence = 1;
        double actualIntelligence = rogue.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void levelUp_Level_ShouldIncreaseToTwo() {
        Rogue rogue = new Rogue("rogue");
        int expectedLevel = 2;
        rogue.levelUp();
        int actualLevel = rogue.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void levelUp_AttributeStrength_ShouldIncreaseToThree() {
        Rogue rogue = new Rogue("rogue");
        double expectedStrength = 3;
        rogue.levelUp();
        double actualStrength = rogue.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void levelUp_AttributeDexterity_ShouldIncreaseToTen() {
        Rogue rogue = new Rogue("rogue");
        double expectedDexterity = 10;
        rogue.levelUp();
        double actualDexterity = rogue.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void levelUp_AttributeIntelligence_ShouldIncreaseToTwo() {
        Rogue rogue = new Rogue("rogue");
        double expectedIntelligence = 2;
        rogue.levelUp();
        double actualIntelligence = rogue.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void dealDamage_LevelPoints_ShouldIncreaseToTen() {
        Rogue rogue = new Rogue("rogue");
        int expectedLevelPoints = 10;
        rogue.dealDamage();
        int actualLevelPoints = rogue.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getWeapon_Typo_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        String expected = "staf didn't match any weapons.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> rogue.getWeapon("staf"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongWeapon_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        String expected = "This weapon is not available for rogues.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> rogue.getWeapon("axe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        String expected = "Required level for this weapon is 2.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> rogue.getWeapon("dagger"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeyToItemList() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(2); // required level
        rogue.getWeapon("dagger");
        String expectedKey = "Weapon";
        String actualKey = rogue.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeysValueToItemList() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(2); // required level
        rogue.getWeapon("dagger");
        String expectedValue = "Dagger";
        String key = rogue.itemList.keySet().toArray()[0].toString();
        String actualValue = rogue.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWeapon_LevelPoints_ShouldIncreaseToFive() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        int expectedLevelPoints = 5;
        rogue.setLevel(2); // required level
        rogue.getWeapon("dagger");
        int actualLevelPoints = rogue.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getArmor_TypoWithSlot_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        String expected = "Not a suitable slot.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> rogue.getArmor("cloth", "toe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_TypoWithArmor_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        String expected = "ploth didn't match any armors.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> rogue.getArmor("ploth","head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongArmor_ShouldThrowInvalidArmorExceptionWithProperMessage() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        String expected = "This armor is not available for rogues.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> rogue.getArmor("plate", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        String expected = "Required level for this armor is 4.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> rogue.getArmor("leather", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeyToItemList() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(4); // required level
        rogue.getArmor("leather", "head");
        String expectedKey = "head";
        String actualKey = rogue.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeysValueToItemList() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(4); // required level
        rogue.getArmor("leather", "head");
        String expectedValue = "Leather";
        String key = rogue.itemList.keySet().toArray()[0].toString();
        String actualValue = rogue.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getArmor_LevelPoints_ShouldIncreaseToTwo() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        int expectedLevelPoints = 2;
        rogue.setLevel(4); // required level
        rogue.getArmor("leather", "head");
        int actualLevelPoints = rogue.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Rogue rogue = new Rogue("rogue");
        double expectedStrength = rogue.primaryAttribute.getStrength();
        rogue.checkTotalAttributes();
        double actualStrength = rogue.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Rogue rogue = new Rogue("rogue");
        double expectedDexterity = rogue.primaryAttribute.getDexterity();
        rogue.checkTotalAttributes();
        double actualDexterity = rogue.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Rogue rogue = new Rogue("rogue");
        double expectedIntelligence = rogue.primaryAttribute.getIntelligence();
        rogue.checkTotalAttributes();
        double actualIntelligence = rogue.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldIncreaseWithArmorHead() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        double expectedDexterity = rogue.primaryAttribute.getDexterity()+2;
        rogue.setLevel(4);
        rogue.getArmor("leather", "head");
        rogue.checkTotalAttributes();
        double actualDexterity = rogue.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldIncreaseWithArmorHeadAndBody() throws InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        double expectedDexterity = rogue.primaryAttribute.getDexterity()+2+2;
        rogue.setLevel(4);
        rogue.getArmor("leather", "head");
        rogue.getArmor("leather", "body");
        rogue.checkTotalAttributes();
        double actualDexterity = rogue.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkDPS_DPS_WithNoWeapon() {
        Rogue rogue = new Rogue("rogue");
        double expectedDPS = 1*(1+(6/100d));
        rogue.checkDPS();
        double actualDPS = rogue.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeapon() throws InvalidWeaponException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(4);
        rogue.getWeapon("dagger");
        double expectedDPS = (5*1)*(1+(6/100d));
        rogue.checkDPS();
        double actualDPS = rogue.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHead() throws InvalidWeaponException, InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(4);
        rogue.getWeapon("dagger");
        rogue.getArmor("leather", "head");
        double expectedDPS = (5*1)*(1+((6+2)/100d));
        rogue.checkDPS();
        double actualDPS = rogue.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHeadAndBody() throws InvalidWeaponException, InvalidArmorException {
        Rogue rogue = new Rogue("rogue");
        rogue.setLevel(4);
        rogue.getWeapon("dagger");
        rogue.getArmor("leather", "head");
        rogue.getArmor("leather", "body");
        double expectedDPS = (5*1)*(1+((6+2+2)/100d));
        rogue.checkDPS();
        double actualDPS = rogue.DPS;

        assertEquals(expectedDPS, actualDPS);
    }
}