package ambroziepaval.codility.lesson10;

import java.util.Arrays;

class Flags {

    public int solution(int[] A) {

        boolean[] peaks = getPeakArray(A);

        int max = 0;
        for (int i = 1; i < Math.sqrt(A.length) + 1; i++) {
            if (!checkFlags(i, peaks)) {
                return i - 1;
            }
            max = i;
        }

        return max;
    }

    private boolean checkFlags(int count, boolean[] peaks) {

        int flags = count;
        int pos = 0;
        while (pos < peaks.length && flags > 0) {
            if (peaks[pos]) {
                flags--;
                pos += count;
            } else {
                pos++;
            }
        }

        return flags == 0;
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

        Flags solution = new Flags();

        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(Arrays.toString(A));

        System.out.println("\nSOLUTION");
        System.out.println(solution.solution(A));
    }
}
