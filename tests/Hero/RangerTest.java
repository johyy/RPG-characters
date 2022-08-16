package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    @Test
    public void newRanger_Level_LevelShouldBeOne() {
        Ranger ranger = new Ranger("ranger");
        int expectedLevel = 1;
        int actualLevel = ranger.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void newRanger_PrimaryAttributes_StrengthShouldBeOne() {
        Ranger ranger = new Ranger("ranger");
        double expectedStrength = 1;
        double actualStrength = ranger.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void newRanger_PrimaryAttributes_DexterityShouldBeSeven() {
        Ranger ranger = new Ranger("ranger");
        double expectedDexterity = 7;
        double actualDexterity = ranger.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void newRanger_PrimaryAttributes_IntelligenceShouldBeOne() {
        Ranger ranger = new Ranger("ranger");
        double expectedIntelligence = 1;
        double actualIntelligence = ranger.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void levelUp_Level_ShouldIncreaseToTwo() {
        Ranger ranger = new Ranger("ranger");
        int expectedLevel = 2;
        ranger.levelUp();
        int actualLevel = ranger.getLevel();

        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void levelUp_AttributeStrength_ShouldIncreaseToTwo() {
        Ranger ranger = new Ranger("ranger");
        double expectedStrength = 2;
        ranger.levelUp();
        double actualStrength = ranger.primaryAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void levelUp_AttributeDexterity_ShouldIncreaseToTwelve() {
        Ranger ranger = new Ranger("ranger");
        double expectedDexterity = 12;
        ranger.levelUp();
        double actualDexterity = ranger.primaryAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void levelUp_AttributeIntelligence_ShouldIncreaseToTwo() {
        Ranger ranger = new Ranger("ranger");
        double expectedIntelligence = 2;
        ranger.levelUp();
        double actualIntelligence = ranger.primaryAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void dealDamage_LevelPoints_ShouldIncreaseToTen() {
        Ranger ranger = new Ranger("ranger");
        int expectedLevelPoints = 10;
        ranger.dealDamage();
        int actualLevelPoints = ranger.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getWeapon_Typo_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        String expected = "staf didn't match any weapons.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> ranger.getWeapon("staf"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongWeapon_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        String expected = "This weapon is not available for rangers.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> ranger.getWeapon("axe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        String expected = "Required level for this weapon is 2.";
        Exception exception = assertThrows(InvalidWeaponException.class, () -> ranger.getWeapon("bow"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeyToItemList() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(2); // required level
        ranger.getWeapon("bow");
        String expectedKey = "Weapon";
        String actualKey = ranger.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getWeapon_Weapon_ShouldPutKeysValueToItemList() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(2); // required level
        ranger.getWeapon("bow");
        String expectedValue = "Bow";
        String key = ranger.itemList.keySet().toArray()[0].toString();
        String actualValue = ranger.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWeapon_LevelPoints_ShouldIncreaseToFive() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        int expectedLevelPoints = 5;
        ranger.setLevel(2); // required level
        ranger.getWeapon("bow");
        int actualLevelPoints = ranger.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void getArmor_TypoWithSlot_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        String expected = "Not a suitable slot.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> ranger.getArmor("cloth", "toe"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_TypoWithArmor_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        String expected = "ploth didn't match any armors.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> ranger.getArmor("ploth","head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongArmor_ShouldThrowInvalidArmorExceptionWithProperMessage() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        String expected = "This armor is not available for rangers.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> ranger.getArmor("plate", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_WrongLevel_ShouldThrowInvalidWeaponExceptionWithProperMessage() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        String expected = "Required level for this armor is 4.";
        Exception exception = assertThrows(InvalidArmorException.class, () -> ranger.getArmor("leather", "head"));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeyToItemList() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(4); // required level
        ranger.getArmor("leather", "head");
        String expectedKey = "head";
        String actualKey = ranger.itemList.keySet().toArray()[0].toString();

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void getArmor_Armor_ShouldPutKeysValueToItemList() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(4); // required level
        ranger.getArmor("leather", "head");
        String expectedValue = "Leather";
        String key = ranger.itemList.keySet().toArray()[0].toString();
        String actualValue = ranger.itemList.get(key);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getArmor_LevelPoints_ShouldIncreaseToTwo() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        int expectedLevelPoints = 2;
        ranger.setLevel(4); // required level
        ranger.getArmor("leather", "head");
        int actualLevelPoints = ranger.getLevelPoints();

        assertEquals(expectedLevelPoints, actualLevelPoints);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesStrength_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Ranger ranger = new Ranger("ranger");
        double expectedStrength = ranger.primaryAttribute.getStrength();
        ranger.checkTotalAttributes();
        double actualStrength = ranger.totalAttribute.getStrength();

        assertEquals(expectedStrength, actualStrength);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Ranger ranger = new Ranger("ranger");
        double expectedDexterity = ranger.primaryAttribute.getDexterity();
        ranger.checkTotalAttributes();
        double actualDexterity = ranger.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesIntelligence_ShouldStayAsPrimaryAttributesWithNoArmor() {
        Ranger ranger = new Ranger("ranger");
        double expectedIntelligence = ranger.primaryAttribute.getIntelligence();
        ranger.checkTotalAttributes();
        double actualIntelligence = ranger.totalAttribute.getIntelligence();

        assertEquals(expectedIntelligence, actualIntelligence);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldIncreaseWithArmorHead() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        double expectedDexterity = ranger.primaryAttribute.getDexterity()+2;
        ranger.setLevel(4);
        ranger.getArmor("leather", "head");
        ranger.checkTotalAttributes();
        double actualDexterity = ranger.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkTotalAttributes_TotalAttributesDexterity_ShouldIncreaseWithArmorHeadAndBody() throws InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        double expectedDexterity = ranger.primaryAttribute.getDexterity()+2+2;
        ranger.setLevel(4);
        ranger.getArmor("leather", "head");
        ranger.getArmor("leather", "body");
        ranger.checkTotalAttributes();
        double actualDexterity = ranger.totalAttribute.getDexterity();

        assertEquals(expectedDexterity, actualDexterity);
    }

    @Test
    public void checkDPS_DPS_WithNoWeapon() {
        Ranger ranger = new Ranger("ranger");
        double expectedDPS = 1*(1+(7/100d));
        ranger.checkDPS();
        double actualDPS = ranger.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeapon() throws InvalidWeaponException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(4);
        ranger.getWeapon("bow");
        double expectedDPS = (10*1)*(1+(7/100d));
        ranger.checkDPS();
        double actualDPS = ranger.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHead() throws InvalidWeaponException, InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(4);
        ranger.getWeapon("bow");
        ranger.getArmor("leather", "head");
        double expectedDPS = (10*1)*(1+((7+2)/100d));
        ranger.checkDPS();
        double actualDPS = ranger.DPS;

        assertEquals(expectedDPS, actualDPS);
    }

    @Test
    public void checkDPS_DPS_WithWeaponAndArmorHeadAndBody() throws InvalidWeaponException, InvalidArmorException {
        Ranger ranger = new Ranger("ranger");
        ranger.setLevel(4);
        ranger.getWeapon("bow");
        ranger.getArmor("leather", "head");
        ranger.getArmor("leather", "body");
        double expectedDPS = (10*1)*(1+((7+2+2)/100d));
        ranger.checkDPS();
        double actualDPS = ranger.DPS;

        assertEquals(expectedDPS, actualDPS);
    }
}