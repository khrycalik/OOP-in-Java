public enum Option {
    LEFT('a',"Go left",Direction.LEFT), 
    RIGHT('d',"Go right",Direction.RIGHT),
    UP('w',"Go up",Direction.UP), 
    DOWN('s',"Go down",Direction.DOWN),
    RESET('r', "Reset the game", null), EXIT('q', "Exit the game", null);

    private final char character;
    private final String description;
    private final Direction direction;

    Option(char character, String description, Direction direction) {
        this.character = character;
        this.description = description;
        this.direction = direction;
    }

    public char getCharacter() {
        return character;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "'" + character + "'" + " => " + description + (direction != null ? (" vector: " + direction) : "");
    }
}
