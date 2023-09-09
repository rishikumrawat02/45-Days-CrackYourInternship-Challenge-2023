class Solution {
    public int makeConnected(int n, int[][] conn) {
        int len=conn.length;
        if(len<n-1) return -1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int con[]: conn){
            int u=con[0]; int v=con[1];
            adj.get(u).add(v); adj.get(v).add(u);
        }
        int comp=0;
        int vis[] = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                comp++;
                helper(i,vis,adj);
            }
        }       
        return comp-1;
    }

    void helper(int src, int vis[], ArrayList<ArrayList<Integer>> adj){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int child: adj.get(cur)){
                if(vis[child]==1) continue;
                vis[child]=1;
                q.add(child);
            }
        }
        return;
    }
}
