# Martian Robots                                                                                                                                                                                                                             
Undertaken in Java using the Gradle build tool

## Requirements

JRE (Java Runtime Environment).

## Running the code

for ease of use, two files have been added to the top level directory:
 - "martian-robots-1.0.jar" - the jar file
 - "sampleInput.txt" - a copy of the provided sample input

 this means when you git clone this repository, you should simply be able to run:
 ```
 $ java -jar martian-robots-1.0.jar sampleInput.txt output.txt
 ```
 it should be able to read in the input file provided and in this case would write
 "output.txt" to the top level of the repository.

## Run commands:
### Compiled:
There are two required command line arguments:\
 **1** - file path for input file\
 **2** - file path for desired output location
```bash
java -jar martian-robots-1.0.jar /path/to/input/file.txt /name/your/output/file.txt
```
eg:
```
java -jar martian-robots-1.0.jar /home/user1/someTestInput.txt /home/user1/output.txt
```

The output will be available as a file at the place specified and will also print to the console.
### From source:
```
$ ./gradlew clean build
```
jar file will be available:
```
build/distributions/[.tar|.zip]/lib/martian-robots-1.0.jar
```
Then follow instructions for **Compiled** as above.
#### Testing:
```
./gradlew clean test
```

## Notes

 * effort has been focused on the hardest parts given the time constraints
 * input values are assumed to be valid and correct (no input error checking)
 * ran a bit short on time so didn't address the following:\
         * The maximum value for any coordinate is 50\
         * All instruction strings will be less than 100 characters in length
 * Next step for the above would be to add in some bounds checking and error handling
