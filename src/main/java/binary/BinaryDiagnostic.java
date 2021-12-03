package binary;

import java.util.ArrayList;
import java.util.List;

public class BinaryDiagnostic {

    private static final String EXAMPLE_ENTRY = "111011101000";

    public static long calculatePartOne(List<String> diagnosticReport) {
        long gammaRate = Long.parseLong(calculateRate(diagnosticReport, true), 2);
        long epsilonRate = Long.parseLong(calculateRate(diagnosticReport, false), 2);
        return gammaRate * epsilonRate;
    }

    public static long calculatePartTwo(List<String> diagnosticReport) {
        long oxygenGeneratorRating = Long.parseLong(findOxygenGeneratorRating(diagnosticReport), 2);
        long co2ScrubberRating = Long.parseLong(findCo2ScrubberRating(diagnosticReport), 2);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    public static String findCo2ScrubberRating(List<String> diagnosticReport) {
        for(int i = 0; i < EXAMPLE_ENTRY.length(); i++) {
            char leastCommonValueOnPosition = (findMostCommonValueOnPosition(diagnosticReport, i) == '0') ? '1' : '0';
            diagnosticReport = selectValuesWithCharAtPosition(diagnosticReport, leastCommonValueOnPosition, i);
            if(diagnosticReport.size() == 1) {
                break;
            }
        }

        return diagnosticReport.get(0);

    }

    public static String findOxygenGeneratorRating(List<String> diagnosticReport) {
        for(int i = 0; i < EXAMPLE_ENTRY.length(); i++) {
            char mostCommonValueOnPosition = findMostCommonValueOnPosition(diagnosticReport, i);
            diagnosticReport = selectValuesWithCharAtPosition(diagnosticReport, mostCommonValueOnPosition, i);
            if(diagnosticReport.size() == 1) {
                break;
            }
        }

        return diagnosticReport.get(0);
    }

    private static List<String> selectValuesWithCharAtPosition(List<String> diagnosticReport, char c, int position) {
        List<String> result = new ArrayList<>();
        for(String entry : diagnosticReport) {
            if(entry.charAt(position) == c) {
                result.add(entry);
            }
        }

        return result;
    }

    private static char findMostCommonValueOnPosition(List<String> report, int position) {
        int zeroCount = 0;
        int oneCount = 0;
        for (String entry : report) {
            if (entry.charAt(position) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        if(oneCount >= zeroCount) {
            return '1';
        } else {
            return '0';
        }
    }

    private static String calculateRate(List<String> diagnosticReport, boolean isGammaRate) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < EXAMPLE_ENTRY.length(); i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (String entry : diagnosticReport) {
                if (entry.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if ((oneCount > zeroCount & isGammaRate) || (oneCount < zeroCount & !isGammaRate)) {
                sb.append("1");
            } else if ((oneCount < zeroCount & isGammaRate) || (oneCount > zeroCount & !isGammaRate)) {
                sb.append("0");
            }
        }

        return sb.toString();
    }

}
