import util.CommandTypes;
import util.Pair;

public class Robot {

    private Pair startPosition;
    private Pair finalPosition;
    private char currentDirection;
    private String finalPositionWithDirection;

    public Robot(String startPositionWithDirection) {
        String[] elements = startPositionWithDirection.split(" ");
        this.startPosition = new Pair(Integer.parseInt(elements[0]),Integer.parseInt(elements[1]));
        currentDirection = elements[2].charAt(0);
    }

    public Pair getStartPosition() {
        return startPosition;
    }

    public Pair getFinalPosition() {
        return finalPosition;
    }

    public char getCurrentDirection() {
        return currentDirection;
    }

    public String getFinalPositionWithDirection() {
        return finalPositionWithDirection;
    }


}
