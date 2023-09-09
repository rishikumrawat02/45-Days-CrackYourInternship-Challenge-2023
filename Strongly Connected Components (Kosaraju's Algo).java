class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<v; i++){
            revAdj.add(new ArrayList<>());
        }
        ArrayList<Integer> topo = new ArrayList<>();
        int vis[] = new int[v];
        for(int i=0; i<v; i++){
            if(vis[i]==0){
                dfs(i,vis,topo,adj);
            }
        }
        
        Collections.reverse(topo);
        
        for(int i=0; i<v; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                revAdj.get(adj.get(i).get(j)).add(i);
            }
        }
        
        int comp=0; Arrays.fill(vis,0);
        for(int node: topo){
            if(vis[node]==0){
                comp++;
                helper(node,vis,revAdj);
            }
        }
        
        return comp;
    }
    
    void helper(int src, int vis[], ArrayList<ArrayList<Integer>> revAdj){
        vis[src]=1;
        for(int child: revAdj.get(src)){
            if(vis[child]==1) continue;
            helper(child,vis,revAdj);
        }
        return;
    }
    
    void dfs(int src, int vis[], ArrayList<Integer> topo, ArrayList<ArrayList<Integer>> adj){
        vis[src]=1;
        for(int child: adj.get(src)){
            if(vis[child]==1) continue;
            dfs(child,vis,topo,adj);
        }
        topo.add(src);
        return;
    }
}
