package Item.Armors;

import Item.Item;

public class Armor {
    Cloth cloth = new Cloth();
    Leather leather = new Leather();
    Mail mail = new Mail();
    Plate plate = new Plate();

    // method for making an armor item out of a string
    public Item checkArmor(String armor) {
        switch (armor) {
            case "cloth":
                return cloth;
            case "leather":
                return leather;
            case "mail":
                return mail;
            case "plate":
                return plate;
            default:
                System.out.println("No armor was equipped");
                return null;
        }
    }

    // method for checking if armor is suitable for a character type
    public boolean checkTypeArmor(String armor, String type) {
        if (type == "mage" && armor == "cloth") {
            return true;
        } else if (type == "ranger" && armor == "leather" || type == "ranger" && armor == "mail") {
            return true;
        } else if (type == "rogue" && armor == "leather" || type == "ranger" && armor == "mail") {
            return true;
        } else if (type == "warrior" && armor == "mail" || type == "warrior" && armor == "plate") {
            return true;
        }

        return false;
    }
}


