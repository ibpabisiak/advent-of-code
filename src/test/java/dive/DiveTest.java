package dive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DiveTest {

    private static final String INPUT_FILE_PATH_1 = "src/test/resources/dive/input1.txt";
    private final List<DiveCommand> input1 = new ArrayList<>();

    @BeforeAll
    public void setup() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1))) {
            lines.collect(Collectors.toList())
                .forEach(i -> input1.add(new DiveCommand(i.split(" ")[0], Integer.parseInt(i.split(" ")[1]))));
        }
    }

    @Test
    public void testPartOne() {
        int correctAnswer = 1635930;
        Assertions.assertEquals(correctAnswer, Dive.calculatePartOne(input1), "Wrong answer");
    }

    @Test
    public void testPartTwo() {
        long correctAnswer = 1781819478;
        Assertions.assertEquals(correctAnswer, Dive.calculatePartTwo(input1), "Wrong answer");
    }
}
