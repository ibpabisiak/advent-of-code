package binary;

import java.util.List;

public class BinaryDiagnostic {

    private static final String EXAMPLE_ENTRY = "111011101000";

    public static long calculatePartOne(List<String> diagnosticReport) {
        long gammaRate = Long.parseLong(calculateGammaRate(diagnosticReport), 2);
        long epsilonRate = Long.parseLong(calculateEpsilonRate(diagnosticReport), 2);
        return gammaRate * epsilonRate;
    }

    private static String calculateGammaRate(List<String> diagnosticReport) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < EXAMPLE_ENTRY.length(); i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for(String entry : diagnosticReport) {
                if(entry.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if(oneCount > zeroCount) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    private static String calculateEpsilonRate(List<String> diagnosticReport) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < EXAMPLE_ENTRY.length(); i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for(String entry : diagnosticReport) {
                if(entry.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if(oneCount > zeroCount) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();
    }

}
