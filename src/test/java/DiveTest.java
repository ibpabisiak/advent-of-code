import dive.DiveCommand;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DiveTest {

    private static final String INPUT_FILE_PATH_1 = "src/test/resources/dive/input1.txt";
    private List<DiveCommand> input1;

    @BeforeAll
    public void setup() throws IOException {
        List<String> in;
        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1))) {
            in = lines.collect(Collectors.toList());
        }
    }

    @Test
    public void testFirstScenario() {

    }
}
