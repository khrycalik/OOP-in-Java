public abstract class Item {
    private int volume;
    private String itemId;

    public Item(int volume, String itemId) {
        this.volume = volume;
        this.itemId = itemId;
    }

    public Item(Item item) {
        this(item.volume, item.itemId);
    }

    public int getVloume() {
        return this.volume;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setVloume(int volume) {
        this.volume = volume;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "ID: " + this.itemId + ", volume: " + this.volume;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || o.getClass() != this.getClass()) return false;
        if (o == this) return true;
        Item tmp = (Item) o;
        // System.out.println("cos");

        return this.volume == tmp.volume && this.itemId.equals(tmp.itemId);
    }
}