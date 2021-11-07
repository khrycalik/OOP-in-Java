import java.util.*;

public class Box extends Item {
    private int capacityUsed;
    private int capacity;
    private ArrayList<Item> items = new ArrayList<>();

    public Box(int volume, String itemId, int capacity) {
        super(volume, itemId);
        this.capacity = capacity;
    }

    public Box(Box box) {
        super(box);
        this.capacity = box.capacity;
        this.capacityUsed = box.capacityUsed;
        this.items = new ArrayList<Item>(box.items);
    }

    public void addItem(Item item) {
        if(item.getClass().equals(this.getClass())) {
            Box tmp = (Box) item;
            if (tmp.items.contains(this)) {
                System.out.println("Cannot put this box into a box when a box is in this box?");
                return;
            }
        }
        if (this.equals(item)) {
            System.out.println("Cannot put box in same box?");
            return;
        }
        if (this.capacityUsed + item.getVloume() <= this.capacity) {
            items.add(item);
            this.capacityUsed += item.getVloume();
        } else {
            System.out.println("Cannot add more items to the box");
        }
    }

    public void removeItem(Item item) {
        for(int i=0; i<this.items.size(); i++) {
            if (this.items.get(i).equals(item)) {
                this.items.remove(i);
                return;
            }
            if (this.items.get(i).getClass().equals(this.getClass())) {
                ((Box) this.items.get(i)).removeItem(item);
            }
        }
    }

    public boolean containsItem(Item item) {
        boolean flag = false;
        for (Item value : this.items) {
            if (value.equals(item)) {
                return true;
            }
            if (value.getClass().equals(this.getClass())) {
                flag = ((Box) value).containsItem(item);
            }
        }
        return flag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        if (o == this) return true;
        Box tmp = (Box) o;
        if(!super.equals(o)) return false;
        for(int i=0; i<this.items.size(); i++) {
            if (!this.items.get(i).equals(tmp.items.get(i))) {
                return false;
            }
        }
        return this.capacity == tmp.capacity;
    }

    @Override
    public String toString() {
        return "[Box] capacity: " + this.capacity + " ,items: \n" + Arrays.toString(this.items.toArray()) + "\n], " + super.toString();
    }

    public int getUsedCapacity() {
        return this.capacityUsed;
    }
}