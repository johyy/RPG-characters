package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;
import Item.Weapons.*;
import Item.Armors.*;
import Item.*;

import java.util.HashMap;

public class Rogue extends Hero {
    PrimaryAttribute primaryAttribute;
    PrimaryAttribute totalAttribute;
    HashMap<String, String> itemList;
    Weapon weapon;
    Armor armor;
    double DPS;

    public Rogue(String name) {
        super(name, new PrimaryAttribute());
        this.primaryAttribute = new PrimaryAttribute(2, 6, 1);
        this.itemList = new HashMap<>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }

    // method sets level to +1 and adds needed attributes
    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
        primaryAttribute.setStrength(primaryAttribute.getStrength()+1);
        primaryAttribute.setDexterity(primaryAttribute.getDexterity()+4);
        primaryAttribute.setIntelligence(primaryAttribute.getIntelligence()+1);
        System.out.println("");
        System.out.println("Level up! Current level is: " + super.getLevel() + ".");
    }

    // method prints out statistics
    @Override
    public void getStats() {
        checkDPS(); // this updates values of DPS and totalAttributes
        System.out.println("");
        System.out.println("STATISTICS");
        System.out.println("Name: " + super.getName());
        System.out.println("Level: " + super.getLevel());
        System.out.println("DPS: " + this.DPS);
        System.out.println("Attributes: ");
        System.out.println("  ~Strength: " + totalAttribute.getStrength());
        System.out.println("  ~Dexterity: " + totalAttribute.getDexterity());
        System.out.println("  ~Intelligence: " + totalAttribute.getIntelligence());
    }

    // method for dealing damage (could be upgraded to damage opponent)
    @Override
    public void dealDamage() {
        checkDPS(); // updates DPS values
        System.out.println();
        System.out.println(super.getName() + " dealt damage with " + this.DPS + " DPS.");
        setLevelPoints(getLevelPoints() + 10); // increases level points
        checkLevelPoints(); // checks if level points are enough for level up
    }

    // method for equipping a weapon
    @Override
    public void getWeapon(String weapon) throws InvalidWeaponException {
        Item testableWeapon = this.weapon.checkWeapon(weapon); // makes an Item out of a string
        if (testableWeapon == null) {
            throw new InvalidWeaponException(weapon + " didn't match any weapons.");  // checks for typos
        } else if (!(this.weapon.checkTypeWeapon(weapon, "rogue"))) {
            throw new InvalidWeaponException("This weapon is not available for rogues."); // checks if current character can equip this weapon
        } else if (testableWeapon.getRequiredLevel() > super.getLevel()) {
            throw new InvalidWeaponException("Required level for this weapon is " + testableWeapon.getRequiredLevel() + "."); // checks if characters level is enough for this weapon
        } else {
            this.itemList.put(testableWeapon.getItemSlot(), testableWeapon.getName()); // puts weapon to its place on HashMap
            System.out.println("");
            System.out.println(testableWeapon.getName() + " added to weapons.");
        }

        setLevelPoints(getLevelPoints() + 5); // increases level points
        checkLevelPoints(); // checks if level points are enough for level up
    }

    // method for equipping an armor
    @Override
    public void getArmor(String armor, String slot) throws InvalidArmorException {
        if (!(slot == "head" || slot == "body" || slot == "body")) {
            throw new InvalidArmorException("Not a suitable slot."); // checks for typos
        }
        Item testableArmor = this.armor.checkArmor(armor); // makes an Item out of a string
        if (testableArmor == null) {
            throw new InvalidArmorException(armor + " didn't match any armors."); // checks for typos
        } else if (!(this.armor.checkTypeArmor(armor, "rogue"))) {
            throw new InvalidArmorException("This armor is not available for rogues."); // checks if current character can equip this armor
        } else if (testableArmor.getRequiredLevel() > super.getLevel()) {
            throw new InvalidArmorException("Required level for this armor is " + testableArmor.getRequiredLevel() + "."); // checks if characters level is enough for this armor
        } else {
            this.itemList.put(slot.toLowerCase(), testableArmor.getName()); // puts armor to its place on HashMap
            System.out.println("");
            System.out.println(testableArmor.getName() + " added to " + slot.toLowerCase() + " as an armor.");
        }

        setLevelPoints(getLevelPoints() + 2); // increases level points
        checkLevelPoints(); // checks if level points are enough for level up
    }

    // method checks for total amount of attributes
    @Override
    public void checkTotalAttributes() {
        this.totalAttribute = new PrimaryAttribute(primaryAttribute.getStrength(), primaryAttribute.getDexterity(), primaryAttribute.getIntelligence()); // makes a new instance of primary attributes
        for (HashMap.Entry<String, String> entry : this.itemList.entrySet()) {  // goes through the armory and adds points to total attributes with every armor
            if (entry.getValue() == "Mail") {
                this.totalAttribute.setDexterity(totalAttribute.getDexterity()+1);
            } else if (entry.getValue() == "Leather") {
                this.totalAttribute.setDexterity(totalAttribute.getDexterity()+2);
            }
        }
    }

    // method checks for total amount of DPS
    @Override
    public void checkDPS() {
        checkTotalAttributes();  // updates values of total attributes
        double base = 1+(totalAttribute.getDexterity())/100;
        if (itemList.containsKey("Weapon")) {
            double weaponDPS = 1;
            for (HashMap.Entry<String, String> entry : this.itemList.entrySet()) { // goes through the weaponry and adds points to total dps
                if (entry.getKey() == "Weapon") {
                    if (entry.getValue() == "Dagger") {
                        weaponDPS = new Dagger().getWeaponDPS();
                    } else if (entry.getValue() == "Sword") {
                        weaponDPS = new Sword().getWeaponDPS();
                    }
                }
            }
            this.DPS = base*weaponDPS; // calculates the total DPS'
        } else {
            this.DPS = base;
        }
    }
}