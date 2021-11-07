public class Laptop extends Item {
    private String mark;

    public Laptop(int volume, String itemId, String mark) {
        super(volume, itemId);
        this.mark = mark;
    }

    public Laptop(Laptop lap) {
        super(lap);
        this.mark = lap.mark;
    }

    @Override
    public String toString() {
        return "[Laptop] mark: " + this.mark + " " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        if (o == this) return true;
        Laptop tmp = (Laptop) o;
        // System.out.println(this.mark + tmp.mark);
        return super.equals(tmp) && this.mark.equals(tmp.mark) ;
    }
}