import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class MartianRobotsApplication {

    public static void main(String[] args) {

        List<String> input = null;
        String inputFilePath = "data/sampleInput.txt";
        String outputFilePath = "data/output.txt";

        try {
            input = Files.readAllLines(Path.of(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : input) {
            System.out.println(line);
        }

        try {
            Files.write(Path.of(outputFilePath), input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
