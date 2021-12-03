package sonar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class SonarSweepTest {

    private static final String INPUT_FILE_PATH_1 = "src/test/resources/sonar-sweep/input1.txt";
    private static final String INPUT_FILE_PATH_2 = "src/test/resources/sonar-sweep/input2.txt";
    private List<Integer> input1;
    private List<Integer> input2;

    @BeforeAll
    public void setup() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1))) {
            input1 = lines.map(Integer::parseInt).collect(Collectors.toList());
        }

        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_2))) {
            input2 = lines.map(Integer::parseInt).collect(Collectors.toList());
        }
    }

    @Test
    public void shouldCountIncreasesOfInput1() {
        int correctAnswer = 1298;
        Assertions.assertEquals(correctAnswer, SonarSweep.calculateFirstScenario(input1), "Wrong count of increases");
    }

    @Test
    public void shouldCountIncreasesOfInput2() {
        int correctAnswer = 1248;
        Assertions.assertEquals(correctAnswer, SonarSweep.calculateSecondScenario(input2), "Wrong count of increases");
    }
}
