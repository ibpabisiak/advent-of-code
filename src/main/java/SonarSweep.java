import java.util.List;

public class SonarSweep {

    public static int calculateFirstScenario(List<Integer> depths) {
        int count = 0;
        for (int i = 1; i < depths.size(); i++) {
            if (depths.get(i) > depths.get(i - 1)) {
                count++;
            }
        }
        return count;
    }

    public static int calculateSecondScenario(List<Integer> depths) {
        int count = 0;
        for (int i = 0; i < depths.size() - 3; i++) {
            int first = depths.get(i) + depths.get(i + 1) + depths.get(i + 2);
            int second = depths.get(i + 1) + depths.get(i + 2) + depths.get(i + 3);
            if (second > first) {
                count++;
            }
        }
        return count;
    }

}
