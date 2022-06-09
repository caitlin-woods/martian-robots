import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MartianRobotsApplication {

    public static void main(String[] args) {

        List<String> input = null;
        List<String> output = new ArrayList<>();
        String inputFilePath = "data/sampleInput.txt";
        String outputFilePath = "data/output.txt";

        try {
            input = Files.readAllLines(Path.of(inputFilePath));
        } catch (IOException e) {
            System.out.println("Please check the input file path and try again.");
            System.exit(0);
        }

        // make and process robots
        for (int i=1; i < input.size(); i++) {

            String line = input.get(i).strip();
            switch (i % 3) {
                case 1:
                    // new robot
                    System.out.println("make new Robot: " + line);
                    break;
                case 2:
                    // move robot
                    System.out.println("move Robot: " + line);
                    break;
                case 3:
                    System.out.println("blank line do nothing" + line);
                    break;
            }
        }


        // end of program, print and write to file
        for (String line : output) {
            System.out.println(line);
        }

        try {
            Files.write(Path.of(outputFilePath), input);
        } catch (IOException e) {
            System.out.println("There was an error writing the solution to disk. " +
                    "Solution still available in the console.");
        }
    }
}
