package binary;

import java.util.List;

public class BinaryDiagnostic {

    private static final String EXAMPLE_ENTRY = "111011101000";

    public static long calculatePartOne(List<String> diagnosticReport) {
        long gammaRate = Long.parseLong(calculateRate(diagnosticReport, true), 2);
        long epsilonRate = Long.parseLong(calculateRate(diagnosticReport, false), 2);
        return gammaRate * epsilonRate;
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
