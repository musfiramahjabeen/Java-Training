class LongestCommonSubstring {
    public static String lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLen = 0, end = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - maxLen, end);
    }
}