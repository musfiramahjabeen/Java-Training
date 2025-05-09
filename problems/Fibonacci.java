public class Fibonacci {
    
    // Memoization approach
    private static int[] memo;
    
    public static int fibMemo(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }
    
    // Dynamic Programming approach (Tabulation)
    public static int fibDP(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 10;
        
        // Initialize memoization array
        memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        System.out.println("Fibonacci using Memoization: " + fibMemo(n));
        System.out.println("Fibonacci using DP (Tabulation): " + fibDP(n));
    }
}