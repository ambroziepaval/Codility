package ambroziepaval.codility.lesson9;

class MaxProfit {

    public int solution(int[] A) {

        if (A.length < 2) {
            return 0;
        }

        int buyPos = 0;
        int sellPos = 1;

        int max = Math.max(0, A[sellPos] - A[buyPos]);

        if (A[sellPos] < A[buyPos]) {
            buyPos = 1;
        }

        for (int i = 2; i < A.length; i++) {

            if (A[i] > A[sellPos] || buyPos >= sellPos) {
                sellPos = i;
            }

            max = Math.max(max, A[sellPos] - A[buyPos]);

            if (A[i] < A[buyPos]) {
                buyPos = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        MaxProfit solution = new MaxProfit();

//        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
//        int[] A = {5, 4, 3, 2, 1};
        int[] A = {8, 9, 3, 6, 1, 2};

        System.out.println(solution.solution(A));
    }
}
