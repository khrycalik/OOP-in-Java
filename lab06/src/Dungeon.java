import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Dungeon {
    private int moves;
    private final List<Vampire> vampires;
    private int playerX;
    private int playerY;
    private final int maxX;
    private final int maxY;
    private final char[][] map;
    private final int numberOfVampires;

    public Dungeon(int maxX, int maxY, int numberOfVampires, int moves) {
        this.maxX = maxX;
        this.maxY = maxY;
        map = new char[maxX][maxY + 1];
        this.moves = moves;
        this.vampires = new ArrayList<>();
        addVampires(numberOfVampires);
        this.numberOfVampires = numberOfVampires;
    }

    public void reload() {
        this.vampires.clear();
        this.moves = 10;
        this.playerX = 0;
        this.playerY = 0;
        addVampires(numberOfVampires);
        refreshMap();
    }

    public int getMoves() {
        return moves;
    }

    public void printStatus() {
        System.out.println("Current coordinates: (" + playerX + ", " + playerY + ")");
        if (vampires != null)
            vampires.forEach(System.out::println);
        System.out.println("Moves left: " + moves);
    }

    public void refreshMap() {
        moveVampires();
        checkStatus();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                map[i][j] = '.';
            }
            map[i][maxY] = '\n';
        }
        for (Vampire i :vampires){
            map[i.getY()][i.getX()] = 'v';
        }

        map[this.playerY][this.playerX] = '@';
        // ---------------
        // 1: print player as '@'
        // 2: print vampires as 'v'
        // ---------------
    }

    public void drawMap() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    public boolean isItWin() {
        return vampires != null && vampires.size() == 0;
    }

    public void movePlayer(Direction direction) {
        System.out.println(direction);
        if (this.playerX + direction.getX() < maxX && this.playerX + direction.getX() >= 0) {
            this.playerX += direction.getX();
        }
        if (this.playerY - direction.getY() < maxY && this.playerY - direction.getY() >= 0) {
            this.playerY -= direction.getY();
        }
        this.moves--;
        // ---------------
        // move player here (remember to decrement left moves)...
        // ---------------
    }

    private void checkStatus() {
        List<Vampire> vam = new ArrayList<>();
        for(Vampire i : vampires) {
            if (this.playerX == i.getX() && this.playerY == i.getY()) {
                vam.add(i);
            }
        }
        vampires.removeAll(vam);
        // ---------------
        // check if there are any vampires to delete, and delete them...
        // ---------------
    }

    private void moveVampires() {
        int r = new Random().nextInt(4);
        for (Vampire i : vampires) {
            if(Math.random() > 0.5) {
                switch (r) {
                    case 0:
                        i.move(Direction.LEFT, maxX, maxY);
                    case 1:
                        i.move(Direction.RIGHT, maxX, maxY);
                    case 2:
                        i.move(Direction.UP, maxX, maxY);
                    case 3:
                        i.move(Direction.DOWN, maxX, maxY);
                }
            }
        }
    }

    private void addVampires(int number) {
        for (int i=0; i<number; i++){
            Vampire vam = new Vampire(maxX, maxY);
            while (vampires.contains(vam)) {
                vam = new Vampire(maxX, maxY);
            }
            vampires.add(vam);
            map[vam.getY()][vam.getX()] = 'v';
        }

        // ---------------
        // add vampires, check if there are not is same position as player or other
        // vampires...
        // ---------------
    }
}
