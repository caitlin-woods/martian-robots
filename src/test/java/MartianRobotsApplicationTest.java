import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MartianRobotsApplicationTest {

    // simple I/O: read in sample input file and write out to data/
    @Test
    public void runApplication_inputOutput_printOutputAndWriteToFile() throws IOException {
        String inputFilePath = "data/sampleInput.txt";
        String outputFilePath = "data/output.txt";
        List<String> expectedOutput = Files.readAllLines(Path.of(inputFilePath));
        List<String> actualOutput = Files.readAllLines(Path.of(outputFilePath));

        assertThat(actualOutput, equalTo(expectedOutput));
    }
}
