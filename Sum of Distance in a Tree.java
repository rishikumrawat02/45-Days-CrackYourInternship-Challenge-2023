class Solution {
    int child[]; int ans[];
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        child=new int[n]; ans=new int[n];
        Arrays.fill(child,1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int edge[]: edges){
            int u=edge[0]; int v=edge[1];
            adj.get(u).add(v); adj.get(v).add(u);
        }
        dfs1(0,-1,adj);
        dfs2(0,-1,adj);
        return ans;
    }

    void dfs1(int root, int par, ArrayList<ArrayList<Integer>> adj){
        for(int chil: adj.get(root)){
            if(chil==par) continue;
            dfs1(chil,root,adj);
            child[root]+=child[chil];
            ans[root]+=ans[chil]+child[chil];
        }
    }

    void dfs2(int root, int par, ArrayList<ArrayList<Integer>> adj){
        for(int chil: adj.get(root)){
            if(par==chil) continue;
            ans[chil]=ans[root]-child[chil]+child[0]-child[chil];
            dfs2(chil,root,adj);
        }
        return;
    }
}
