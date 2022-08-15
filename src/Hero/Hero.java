package Hero;

import Exceptions.InvalidArmorException;
import Exceptions.InvalidWeaponException;

import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private int levelPoints;
    private double DPS;
    private PrimaryAttribute primaryAttribute;
    private PrimaryAttribute totalAttribute;

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevelPoints(int levelPoints) {
        this.levelPoints = levelPoints;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getLevelPoints() {
        return levelPoints;
    }


    public abstract void levelUp();
    public abstract void getStats();
    public abstract void dealDamage();
    public abstract void getWeapon(String weapon) throws InvalidWeaponException;
    public abstract void getArmor(String armor, String slot) throws InvalidArmorException;
    public abstract void checkTotalAttributes();
    public abstract void checkDPS();
    public void checkLevelPoints() {
        if (this.levelPoints >= 100) {
            levelUp();
            this.levelPoints = 0;
        }
    }

    public Hero(String name, PrimaryAttribute primaryAttribute) {
        this.name = name;
        this.level = 1;
        this.levelPoints = 0;
        this.primaryAttribute = primaryAttribute;
    }


}
