import util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MartianRobotsApplication {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide the following arguments:" +
                    "\n1 - file path for input file" +
                    "\n2 - file path for desired output location");
            System.exit(0);
        }
        
        List<String> input = null;
        List<String> output = new ArrayList<>();
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            input = Files.readAllLines(Path.of(inputFilePath));
        } catch (IOException e) {
            System.out.println("Please check the input file path and try again.");
            System.exit(0);
        }

        Pair minCoordinates = new Pair(0,0);
        Pair maxCoordinates = new Pair(Integer.parseInt(input.get(0).split(" ")[0]),Integer.parseInt(input.get(0).split(" ")[1]));
        List<Pair> scentPoints = new ArrayList<>();
        Robot robot = null;
        String robotOutput = null;

        // make and process robots
        for (int i=1; i < input.size(); i++) {

            String line = input.get(i).strip();
            switch (i % 3) {
                case 1:
                    // new robot
                    robot = new Robot(line,  minCoordinates, maxCoordinates, scentPoints);
                    break;
                case 2:
                    // move robot
                    robotOutput = robot.move(line);
                    updateScentPoints(robotOutput, scentPoints);
                    output.add(robotOutput);
                    break;
            }
        }


        // end of program, print and write to file
        output.forEach(System.out::println);

        try {
            Files.write(Path.of(outputFilePath), output);
        } catch (IOException e) {
            System.out.println("There was an error writing the solution to disk. " +
                    "Solution still available in the console.");
        }
    }

    private static void updateScentPoints(String robotOutput, List<Pair> scentPoints) {
        if (robotOutput.contains("LOST")) {
            scentPoints.add(new Pair(Integer.parseInt(robotOutput.split(" ")[0]), Integer.parseInt(robotOutput.split(" ")[1])));
        }
    }
}
