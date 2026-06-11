import java.util.*;

class Solution {

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int v : graph[u]) {

                if (!visited[v]) {

                    visited[v] = true;
                    depth[v] = depth[u] + 1;

                    q.offer(v);
                }
            }
        }

        int k = 0;

        for (int i = 1; i <= n; i++) {
            k = Math.max(k, depth[i]);
        }

        if (k == 0) {
            return 0;
        }

        return power(2, k - 1);
    }

    private int power(long base, int exp) {

        int MOD = 1000000007;

        long ans = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;

            exp >>= 1;
        }

        return (int) ans;
    }
}