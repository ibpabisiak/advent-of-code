package binary;

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
public class BinaryDiagnosticTest {


    private static final String INPUT_FILE_PATH_1 = "src/test/resources/binary-diagnostic/input1.txt";
    private final List<String> diagnosticReport = new ArrayList<>();

    @BeforeAll
    public void setup() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1))) {
            diagnosticReport.addAll(lines.collect(Collectors.toList()));
        }
    }

    @Test
    public void testPartOne() {
        long correctAnswer = 3813416;
        Assertions.assertEquals(correctAnswer, BinaryDiagnostic.calculatePartOne(diagnosticReport), "Wrong answer");
    }

}
