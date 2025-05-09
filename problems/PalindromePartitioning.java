public class PalindromePartitioning {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] minCuts = new int[n];
        
        for (int i = 0; i < n; i++) {
            minCuts[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        minCuts[i] = 0;
                    } else {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return minCuts[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts required: " + minCut(s));
    }
}
