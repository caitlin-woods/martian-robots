import util.CommandTypes;
import util.Pair;

import java.util.List;

public class Robot {

    private Pair startPosition;
    private Pair finalPosition;
    private char currentDirection;
    private String finalPositionWithDirection;
    private Pair minGrid;
    private Pair maxGrid;
    private List<Pair> scentPoints;
    private boolean lost = false;
    private Pair nextPosition;

    public Robot(String startPositionWithDirection,  Pair minGrid, Pair maxGrid, List<Pair> scentPoints) {
        this.minGrid = minGrid;
        this.maxGrid = maxGrid;
        this.scentPoints = scentPoints;
        String[] elements = startPositionWithDirection.split(" ");
        startPosition = new Pair(Integer.parseInt(elements[0]),Integer.parseInt(elements[1]));
        finalPosition = startPosition;
        currentDirection = elements[2].charAt(0);
    }

    protected String move(String instructions) {
        for (char letter : instructions.toCharArray()) {
            if (lost) {
                break;
            }
            switch (CommandTypes.valueOf(String.valueOf(letter))) {
                case L:
                case R:
                    currentDirection = Direction.change(currentDirection, letter);
                    break;
                case F:
                    nextPosition = Direction.forward(finalPosition, currentDirection);
                    if (!lostCheck()) {
                        finalPosition = nextPosition;
                    }
                    if (scentPoints.contains(finalPosition)) {
                        lost = false;
                    }
                    break;
            }
        }
        finalPositionWithDirection = finalPosition.toString() + " " + currentDirection + (lost ? " LOST" : "");
        return finalPositionWithDirection;
    }

    private boolean lostCheck() {
        lost =  nextPosition.x() > maxGrid.x() || nextPosition.y() > maxGrid.y() || nextPosition.x() < minGrid.x() || nextPosition.y() < minGrid.y();
        return lost; // need to return true
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
