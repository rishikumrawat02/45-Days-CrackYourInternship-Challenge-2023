class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int vis[] = new int[v];
        for(int i=0; i<v; i++){
            if(vis[i]==0){
                vis[i]=1;
                if(!helper(i,v,adj,vis)) return false;
            }
        }
        return true;
    }
    
    boolean helper(int src, int n, ArrayList<ArrayList<Integer>> adj, int vis[]){
        for(int child: adj.get(src)){
            if(vis[child]==vis[src]) return false;
            if(vis[child]!=0) continue;
            vis[child]=(vis[src]==1)?2:1;
            if(!helper(child,n,adj,vis)) return false;
        }
        return true;
    }
}
