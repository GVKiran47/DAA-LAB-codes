public class LongestCommonSubsequence {

    public static void lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        System.out.println("Length of LCS: " + dp[m][n]);


        int i = m, j = n;
        StringBuilder lcsStr = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsStr.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // LCS is built in reverse
        System.out.println("LCS string: " + lcsStr.reverse().toString());
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bcef";

        lcs(s1, s2);
    }
}
