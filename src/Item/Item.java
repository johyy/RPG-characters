package Item;

public abstract class Item {
    private String name;
    private int requiredLevel;

    private String itemSlot;

    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public String getItemSlot() {
        return itemSlot;
    }

}
