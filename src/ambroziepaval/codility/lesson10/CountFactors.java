package ambroziepaval.codility.lesson10;

class CountFactors {


    public int solution(int N) {
        int sqrt = (int) Math.sqrt(N);

        int factorCount = 0;
        if (sqrt * sqrt == N) {
            factorCount++;
        } else {
            sqrt++;
        }

        for (int i = 1; i < sqrt; i++) {
            if (N % i == 0) {
                factorCount += 2;
            }
        }

        return factorCount;
    }

    public static void main(String[] args) {

        CountFactors solution = new CountFactors();

        System.out.println(solution.solution(41));
    }
}
