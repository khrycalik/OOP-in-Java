import java.util.Objects;
import java.util.Random;

public class Vampire {
    private int x;
    private int y;

    public Vampire(int maxX, int maxY) {
        randomize(maxX, maxY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction, int maxX, int maxY) {
        if (this.x + direction.getX() < maxX && this.x + direction.getX() >= 0) {
            this.x += direction.getX();
        }
        if (this.y - direction.getY() < maxY && this.y - direction.getY() >= 0) {
            this.y -= direction.getY();
        }
        // ---------------
        // move vampire logic here (check if vampire will not move out of map!)...
        // ---------------
    }

    public void randomize(int maxX, int maxY) {
        Random ran = new Random();
        x = ran.nextInt(maxX);
        y = ran.nextInt(maxY);
        while (x ==0 && y ==0) {
            x = ran.nextInt(maxX);
            y = ran.nextInt(maxY);
        }
    }

    public boolean isDifferentThanCoordinates(Vampire vampire) {
        return isDifferentThanCoordinates(vampire.getX(), vampire.getY());
    }

    public boolean isDifferentThanCoordinates(int x, int y) {
        return this.x != x || this.y != y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vampire))
            return false;
        Vampire vampire = (Vampire) o;
        return getX() == vampire.getX() && getY() == vampire.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "v " + y + ", " + x;
    }
}
