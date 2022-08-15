package Hero;

public class PrimaryAttribute {
    private double strength;
    private double dexterity;
    private double intelligence;

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getStrength() {
        return strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public PrimaryAttribute() {
    }
    public PrimaryAttribute(double strength, double dexterity, double intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
}
