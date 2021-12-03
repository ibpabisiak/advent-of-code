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
public class MainTest {

    List<Integer> input;

    @BeforeAll
    public void setup() throws IOException {
        String fileName = "src/test/resources/input1.txt";
        try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
            input = lines.map(Integer::parseInt).collect(Collectors.toList());
        }
    }

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        input.forEach(System.out::println);
        Assertions.assertEquals("hello world", Main.hiWorld(), "Wrong message");
    }
}
