import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MartianRobotsApplicationTest {

    @Test
    public void runApplication_integrationTest() throws IOException {
        String inputFilePath = "data/sampleInput.txt";
        String outputFilePath = "data/output.txt";

        String sampleAnswers = "data/sampleOutput.txt";

        MartianRobotsApplication.main(new String[]{inputFilePath,outputFilePath});

        List<String> expectedOutput = Files.readAllLines(Path.of(sampleAnswers));
        List<String> actualOutput = Files.readAllLines(Path.of(outputFilePath));

        assertThat(actualOutput, equalTo(expectedOutput));
    }
}
