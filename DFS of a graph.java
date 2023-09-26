

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        helper(0,res,adj,vis);
        return res;
    }
    
    void helper(int node, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj, int vis[]){
        vis[node]=1; res.add(node);
        for(int child: adj.get(node)){
            if(vis[child]==1) continue;
            helper(child,res,adj,vis);
        }
        return;
    }
}
