public class RecursiveStaircase {
    
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        int n = 4;  // Example: N = 4
        System.out.println("Distinct ways to climb " + n + " stairs: " + countWays(n));
    }
}
