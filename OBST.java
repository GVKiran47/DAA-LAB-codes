 class OptimalBST {
    public static int optimalBST(int[] keys, int[] freq, int n) {
        int[][] cost = new int[n][n];

        // cost when the tree contains only one key
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // Now we need to consider chains of length 2, 3... n
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // sum of frequencies from i to j
                int sum = sum(freq, i, j);

                // Try making all keys in interval keys[i..j] as root
                for (int r = i; r <= j; r++) {
                    int leftCost = (r > i) ? cost[i][r - 1] : 0;
                    int rightCost = (r < j) ? cost[r + 1][j] : 0;
                    int totalCost = leftCost + rightCost + sum;

                    if (totalCost < cost[i][j]) {
                        cost[i][j] = totalCost;
                    }
                }
            }
        }

        return cost[0][n - 1];
    }

    // Utility function to sum frequencies
    private static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};
        int n = keys.length;

        System.out.println("Cost of Optimal BST is: " + optimalBST(keys, freq, n));
    }
}

