public class TSP {
    static int V = 4; // number of cities
    static int[][] graph = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
    };

    static boolean[] visited = new boolean[V];
    static int minPath = Integer.MAX_VALUE;

    static void tsp(int currentPos, int count, int cost, int start) {
        if (count == V && graph[currentPos][start] > 0) {
            minPath = Math.min(minPath, cost + graph[currentPos][start]);
            return;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph[currentPos][i] > 0) {
                visited[i] = true;
                tsp(i, count + 1, cost + graph[currentPos][i], start);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        visited[0] = true; // start from city 0
        tsp(0, 1, 0, 0);
        System.out.println("Minimum cost: " + minPath);
    }
}
