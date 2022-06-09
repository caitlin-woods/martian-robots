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
}
