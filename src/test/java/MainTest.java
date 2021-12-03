import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void shouldReturnHelloWorld() {
        Assertions.assertEquals("hello world", Main.hiWorld(), "Wrong message");
    }
}
