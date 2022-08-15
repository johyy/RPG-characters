package Item.Weapons;

import Item.Item;

public class Weapon {
    Axe axe = new Axe();
    Bow bow = new Bow();
    Dagger dagger = new Dagger();
    Hammer hammer = new Hammer();
    Staff staff = new Staff();
    Sword sword = new Sword();
    Wand wand = new Wand();

    // method for making a weapon item out of a string
    public Item checkWeapon(String weapon) {
        switch (weapon) {
            case "axe":
                return axe;
            case "bow":
                return bow;
            case "dagger":
                return dagger;
            case "hammer":
                return hammer;
            case "staff":
                return staff;
            case "sword":
                return sword;
            case "wand":
                return wand;
            default:
                System.out.println("No weapon was equipped");
                return null;
        }
    }

    // method for checking if weapon is suitable for a character type
    public boolean checkTypeWeapon(String weapon, String type) {
        if (type == "mage" && weapon == "staff" || type == "mage" && weapon == "wand" ) {
            return true;
        } else if (type == "ranger" && weapon == "bow") {
            return true;
        } else if (type == "rogue" && weapon == "dagger" || type == "rogue" && weapon == "sword") {
            return true;
        } else if  (type == "warrior" && weapon == "axe" || type == "warrior" && weapon == "hammer" || type == "warrior" && weapon == "sword") {
            return true;
        }

        return false;
    }
}
