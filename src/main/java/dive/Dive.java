package dive;

import java.util.List;

public class Dive {

    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";

    public static int calculatePartOne(List<DiveCommand> commands) {
        int horizontal = 0;
        int depth = 0;

        for (DiveCommand command : commands) {
            switch (command.getCommand()) {
                case FORWARD:
                    horizontal += command.getValue();
                    break;
                case DOWN:
                    depth += command.getValue();
                    break;
                case UP:
                    depth -= command.getValue();
                    break;
            }

        }
        return horizontal * depth;
    }

    public static long calculatePartTwo(List<DiveCommand> commands) {
        long aim = 0;
        long depth = 0;
        long horizontal = 0;

        for (DiveCommand command : commands) {
            switch (command.getCommand()) {
                case FORWARD:
                    horizontal += command.getValue();
                    if (aim > 0) {
                        depth += aim * command.getValue();
                    }
                    break;
                case DOWN:
                    aim += command.getValue();
                    break;
                case UP:
                    aim -= command.getValue();
                    break;
            }
        }
        return horizontal * depth;
    }
}
