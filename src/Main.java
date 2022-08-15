import Hero.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Mage velho = new Mage("Velho");
        Ranger vartija = new Ranger("Vartija");
        Rogue roisto = new Rogue("Roisto");
        Warrior soturi = new Warrior("Soturi");

        velho.getStats();
        int i = 0;
        while (i < 100) {
            velho.dealDamage();
            i++;
        }
        velho.getStats();
        velho.getWeapon("wand");
        velho.getStats();
        velho.getWeapon("staff");
        velho.getArmor("cloth", "head");
        velho.getStats();
    }
}
