package ambroziepaval.codility.lesson9;

class MaxDoubleSliceSum {

    public int solution(int[] A) {

        // calculate MaxSliceSum positions within the array (1, A.length-1)
        int max = A[1];
        int currentMax = A[1];

        int currentStart = 1;
        int currentEnd;
        int start = 1;
        int end = 1;

        for (int i = 2; i < A.length - 1; i++) {

            if (currentMax + A[i] > A[i]) {
                currentMax = currentMax + A[i];
                currentEnd = i;
            } else {
                currentMax = A[i];
                currentStart = i;
                currentEnd = i;
            }

            if (currentMax > max) {
                max = currentMax;
                start = currentStart;
                end = currentEnd;
            }
        }


        // select the minimum number from the max slice
        int minNr = A[start];
        for (int i = start + 1; i < end; i++) {
            if (A[i] < minNr) {
                minNr = A[i];
            }
        }

        if (A.length > 3 && minNr > 0 && (start > 1 || end < A.length - 2)) {
            return max;
        }

        return max - minNr;
    }

    public static void main(String[] args) {

        MaxDoubleSliceSum solution = new MaxDoubleSliceSum();

//        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
//        int[] A = {5, 4, 3, 2, 1};
//        int[] A = {8, 9, 3, 6, 1, 2};
//        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
//        int[] A = {5, 17, 0, 3};
//        int[] A = {5, 5, 5};
        int[] A = {6, 1, 5, 6, 4, 2, 9, 4};

        System.out.println(solution.solution(A));
    }
}
