package ambroziepaval.codility;

class MaxSliceSum {

    public int solution(int[] A) {

        int max = A[0];
        int currentMax = A[0];

        for (int i = 1; i < A.length; i++) {

            currentMax = Math.max(currentMax + A[i], A[i]);
            max = Math.max(max, currentMax);
        }

        return max;
    }

    public static void main(String[] args) {

        MaxSliceSum solution = new MaxSliceSum();

        int[] A = {3, 2, -6, 4, 0};

        System.out.println(solution.solution(A));
    }
}
