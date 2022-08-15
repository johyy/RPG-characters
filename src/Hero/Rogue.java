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

    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
        primaryAttribute.setStrength(primaryAttribute.getStrength()+1);
        primaryAttribute.setDexterity(primaryAttribute.getDexterity()+4);
        primaryAttribute.setIntelligence(primaryAttribute.getIntelligence()+1);
    }
    @Override
    public void getStats() {
        checkTotalAttributes();
        System.out.println("");
        System.out.println("STATISTICS");
        System.out.println("Name: " + super.getName());
        System.out.println("Level: " + super.getLevel());
        System.out.println("Attributes: ");
        System.out.println("  ~Strength: " + totalAttribute.getStrength());
        System.out.println("  ~Dexterity: " + totalAttribute.getDexterity());
        System.out.println("  ~Intelligence: " + totalAttribute.getIntelligence());
    }

    @Override
    public void dealDamage() {
        setLevelPoints(getLevelPoints() + 10);
        checkLevelPoints();
    }

    @Override
    public void getWeapon(String weapon) throws InvalidWeaponException {
        Item testableWeapon = this.weapon.checkWeapon(weapon);
        if (testableWeapon == null) {
            throw new InvalidWeaponException(weapon + " didn't match any weapons.");
        } else if (!(this.weapon.checkTypeWeapon(weapon, "rogue"))) {
            throw new InvalidWeaponException("This weapon is not available for rogues.");
        } else if (testableWeapon.getRequiredLevel() > super.getLevel()) {
            throw new InvalidWeaponException("Required level for this weapon is " + testableWeapon.getRequiredLevel() + ".");
        } else {
            this.itemList.put(testableWeapon.getItemSlot(), testableWeapon.getName());
            System.out.println(testableWeapon.getName() + " added to weapons.");
        }
    }

    @Override
    public void getArmor(String armor, String slot) throws InvalidArmorException {
        if (!(slot == "head" || slot == "body" || slot == "body")) {
            throw new InvalidArmorException("Not a suitable slot");
        }
        Item testableArmor = this.armor.checkArmor(armor);
        if (testableArmor == null) {
            throw new InvalidArmorException(armor + " didn't match any armors.");
        } else if (!(this.armor.checkTypeArmor(armor, "rogue"))) {
            throw new InvalidArmorException("This armor is not available for rogues.");
        } else if (testableArmor.getRequiredLevel() > super.getLevel()) {
            throw new InvalidArmorException("Required level for this armor is " + testableArmor.getRequiredLevel() + ".");
        } else {
            this.itemList.put(slot.toLowerCase(), testableArmor.getName());
            System.out.println(testableArmor.getName() + " added to " + slot.toLowerCase() + " as an armor.");
        }
    }
    @Override
    public void checkTotalAttributes() {
        this.totalAttribute = new PrimaryAttribute(primaryAttribute.getStrength(), primaryAttribute.getDexterity(), primaryAttribute.getIntelligence());
        for (HashMap.Entry<String, String> entry : this.itemList.entrySet()) {
            if (entry.getValue() == "Mail") {
                this.totalAttribute.setStrength(totalAttribute.getStrength()*1.8);
                this.totalAttribute.setDexterity(totalAttribute.getDexterity()*1.1);
            } else if (entry.getValue() == "Plate") {
                this.totalAttribute.setStrength(totalAttribute.getStrength()*2.5);
            }
        }
    }

    @Override
    public void checkDPS() {
        checkTotalAttributes();
        double base = 1+(totalAttribute.getStrength()+totalAttribute.getDexterity()+totalAttribute.getIntelligence())/100;
        double weaponDPS = 0;
        for (HashMap.Entry<String, String> entry : this.itemList.entrySet()) {
            if (entry.getKey() == "Weapon") {
                if (entry.getValue() == "Axe") {
                    weaponDPS = new Axe().getWeaponDPS();
                } else if (entry.getValue() == "Bow") {
                    weaponDPS = new Bow().getWeaponDPS();
                } else if (entry.getValue() == "Dagger") {
                    weaponDPS = new Dagger().getWeaponDPS();
                } else if (entry.getValue() == "Hammer") {
                    weaponDPS = new Hammer().getWeaponDPS();
                } else if (entry.getValue() == "Staff") {
                    weaponDPS = new Staff().getWeaponDPS();
                } else if (entry.getValue() == "Sword") {
                    weaponDPS = new Sword().getWeaponDPS();
                } else if (entry.getValue() == "Wand") {
                    weaponDPS = new Wand().getWeaponDPS();
                }
            }
        }
        this.DPS = base+weaponDPS;
    }

}