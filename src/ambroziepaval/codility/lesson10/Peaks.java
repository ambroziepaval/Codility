package ambroziepaval.codility.lesson10;

import java.util.Arrays;

class Peaks {

    public int solution(int[] A) {

        boolean[] peaks = getPeakArray(A);

        int peakCount = 0;
        for (boolean peak : peaks) {
            if (peak) peakCount++;
        }
        if (peakCount <= 1) {
            return peakCount;
        }

        while (peakCount > 1) {

            if (A.length % peakCount == 0) {

                int slice = A.length / peakCount;

                boolean isValid = true;
                int factor = 0;
                while ((factor + 1) * slice <= A.length) {
                    boolean hasPeak = false;
                    for (int i = slice * factor; i < slice * (factor + 1); i++) {
                        if (peaks[i]) {
                            hasPeak = true;
                            break;
                        }
                    }
                    if (!hasPeak) {
                        isValid = false;
                        break;
                    }
                    factor++;
                }
                if (isValid) {
                    return peakCount;
                }
            }

            peakCount--;
        }

        return peakCount;
    }

    private boolean[] getPeakArray(int[] A) {

        boolean[] peaks = new boolean[A.length];
        peaks[0] = false;
        peaks[A.length - 1] = false;

        for (int i = 1; i < A.length - 1; i++) {
            peaks[i] = A[i - 1] < A[i] && A[i] > A[i + 1];
        }

        return peaks;
    }

    public static void main(String[] args) {

        Peaks solution = new Peaks();

        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(Arrays.toString(A));

        System.out.println("\nSOLUTION");
        System.out.println(solution.solution(A));
    }
}
