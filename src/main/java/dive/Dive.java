package dive;

import java.util.List;

public class Dive {

    public static final String FORWARD = "forward";
    public static final String DOWN = "down";
    public static final String UP = "up";

    public static int calculate(List<DiveCommand> commands) {
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


}
