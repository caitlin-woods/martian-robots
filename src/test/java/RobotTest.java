import org.junit.Before;
import org.junit.Test;
import util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RobotTest {

    private Robot actualRobot;
    Pair expectedStartPosition;
    char expectedCurrentDirection;
    Pair minGrid;
    Pair maxGrid;
    List<Pair> scentPoints;

    @Before
    public void before() {
        minGrid = new Pair(0,0);
        maxGrid = new Pair(5,3);
        actualRobot = new Robot("1 1 E", minGrid, maxGrid, new ArrayList<>());
        expectedStartPosition = new Pair(1,1);
        expectedCurrentDirection = 'E';
        scentPoints = new ArrayList<>();
        scentPoints.add(new Pair(3,3));
    }

    @Test
    public void constructorTest() {
        assertThat(actualRobot.getStartPosition(), equalTo(expectedStartPosition));
        assertThat(actualRobot.getCurrentDirection(), equalTo(expectedCurrentDirection));
    }

    @Test
    public void changeDirectionTest() {
        actualRobot.move("LRLR");
        assertThat(actualRobot.getCurrentDirection(), equalTo(expectedCurrentDirection));

        actualRobot.move("LLLL");
        assertThat(actualRobot.getCurrentDirection(), equalTo(expectedCurrentDirection));

        actualRobot.move("RRRR");
        assertThat(actualRobot.getCurrentDirection(), equalTo(expectedCurrentDirection));

        actualRobot.move("RRRL");
        assertThat(actualRobot.getCurrentDirection(), equalTo('W'));
    }

    @Test
    public void robotForwardMoveTest() {
        actualRobot.move("RFRFRFRF");
        assertThat(actualRobot.getFinalPosition(), equalTo(expectedStartPosition));
        assertThat(actualRobot.getCurrentDirection(), equalTo(expectedCurrentDirection));

        actualRobot.move("F");
        assertThat(actualRobot.getFinalPosition(), equalTo(new Pair(2,1)));

        actualRobot.move("LF");
        assertThat(actualRobot.getFinalPosition(), equalTo(new Pair(2,2)));
    }

    @Test
    public void robotOutOfBoundsTest() throws IOException {
        List<String> sampleAnswers = Files.readAllLines(Path.of("data/sampleOutput.txt"));

        actualRobot = new Robot("0 3 W", minGrid, maxGrid, scentPoints);
        String robotOutput = actualRobot.move("LLFFFLFLFL");
        assertThat(actualRobot.getFinalPositionWithDirection(), equalTo(sampleAnswers.get(2)));
    }
}
