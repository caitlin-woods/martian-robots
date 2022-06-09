import util.Pair;

import java.util.Map;

import static java.util.Map.entry;

public class Direction {

    private static Map<Character, Integer> compass = Map.ofEntries(
            entry('N',0),
            entry('E',90),
            entry('S',180),
            entry('W',270));

    private static Map <Character, Integer> leftRight = Map.ofEntries(
            entry('R',90),
            entry('L',-90));

    private static Map<Character, Pair> forwardIncDec = Map.ofEntries(
            entry('N',new Pair(0,1)),
            entry('E',new Pair(1,0)),
            entry('S',new Pair(0,-1)),
            entry('W',new Pair(-1,0)));

    public static char change(char currentDirection, char turn) {
        char newDirection = 0;
        int direction = (compass.get(currentDirection) + leftRight.get(turn) + 360) % 360;
        for (Map.Entry<Character, Integer> entry: compass.entrySet()){
            if (entry.getValue() == direction) {
                newDirection = entry.getKey();
            }
        }
        return newDirection;
    }

    public static Pair forward(Pair currentPosition, char currentDirection) {
        Pair move = forwardIncDec.get(currentDirection);
        int x = currentPosition.x() + move.x();
        int y = currentPosition.y() + move.y();
        return new Pair(x,y);
    }
}
