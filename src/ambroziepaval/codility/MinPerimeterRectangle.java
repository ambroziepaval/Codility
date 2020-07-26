package ambroziepaval.codility;

class MinPerimeterRectangle {

    public int solution(int N) {
        int sqrt = (int) Math.sqrt(N);

        int minPerimeter = 2 * (1 + N);
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {

                int perimeter = 2 * (i + N / i);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }

    public static void main(String[] args) {

        MinPerimeterRectangle solution = new MinPerimeterRectangle();

        System.out.println(solution.solution(36));
    }
}
