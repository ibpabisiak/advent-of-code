package bingo;

import bingo.Board.Point;
import dive.DiveCommand;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.commons.util.StringUtils;

@TestInstance(Lifecycle.PER_CLASS)
public class GiantSquidTest {

    private static final String INPUT_FILE_PATH_1_1 = "src/test/resources/giant-squid/input1_1.txt";
    private static final String INPUT_FILE_PATH_1_2 = "src/test/resources/giant-squid/input1_2.txt";
    private final List<Integer> values = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();
    private final List<DiveCommand> input1 = new ArrayList<>();


    @BeforeAll
    public void setup() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1_1))) {
            values.addAll(
                Arrays.stream(lines.collect(Collectors.toList()).get(0).split(",")).map(Integer::parseInt)
                    .collect(
                        Collectors.toList()));
        }


        try (Stream<String> lines = Files.lines(Paths.get(INPUT_FILE_PATH_1_2))) {

            Point[][] points = new Point[5][5];
            int j = 0;
            for(String line : lines.collect(Collectors.toList())) {
                if(StringUtils.isNotBlank(line)) {
                    String[] row = line.trim().split("\\s+");
                    int max = 5;
                    for (int i = 0; i < max; i++) {
                        points[j][i] = new Point(Integer.parseInt(row[i]));
                    }
                    j++;
                } else {
                    j = 0;
                    boards.add(new Board(points));
                    points = new Point[5][5];
                }
            }

        }
        System.out.println(values);
    }

    @Test
    public void testPartOne() {
//        int correctAnswer = 1635930;
//        Assertions.assertEquals(correctAnswer, Dive.calculatePartOne(input1), "Wrong answer");
    }
}
