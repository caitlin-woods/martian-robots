import org.junit.Before;
import org.junit.Test;
import util.Pair;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RobotTest {

    private Robot actualRobot;
    Pair expectedStartPosition;
    char expectedCurrentDirection;

    @Before
    public void before() {
        actualRobot = new Robot("1 1 E");
        expectedStartPosition = new Pair(1,1);
        expectedCurrentDirection = 'E';
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
}
