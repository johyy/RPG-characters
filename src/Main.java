import Hero.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // creating the characters
        Mage mage = new Mage("Hal Apenyo");
        Ranger ranger = new Ranger("Sanos Talbot");
        Rogue rogue = new Rogue("Mad Eyed Leon");
        Warrior warrior = new Warrior("Iron Stare");

        // getting the statistics of the characters
        mage.getStats();
        ranger.getStats();
        rogue.getStats();
        warrior.getStats();

        // mage deals damage for 10 times and level goes up
        for (int i = 0; i < 10; i++) {
            mage.dealDamage();
        }

        // mage equips an armor
        mage.getArmor("cloth", "body");
        /* possible armors:
        cloth, leather, mail, plate

        possible slots:
        head, body, legs
         */

        // mage equips a weapon
        mage.getWeapon("staff");
        /* possible weapons:
        axe, bow, dagger, hammer, staff, sword, wand
         */

        mage.getStats(); // DPS and attributes have gone up because of the equipment and the leveling up
        
    }
}
