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
}
