public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++)
            {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60}; // Example dimensions
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(arr));
    }
}
