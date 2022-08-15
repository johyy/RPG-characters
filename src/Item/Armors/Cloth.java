package Item.Armors;

import Hero.PrimaryAttribute;
import Item.Item;

public class Cloth extends Item {
    PrimaryAttribute primaryAttribute;

    public Cloth() {
        super.setName("Cloth");
        super.setRequiredLevel(4);
        this.primaryAttribute = new PrimaryAttribute(2, 2, 2);
    }
}
