class Solution {
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> connection : con) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1, adj, disc, low, result);
            }
        }

        return result;
    }

    private void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low,
            List<List<Integer>> result) {
        disc[u] = time;
        low[u] = time;
        time++;

        for (int v : adj.get(u)) {
            if (v == parent)
                continue;

            if (disc[v] == -1) {
                dfs(v, u, adj, disc, low, result);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
