class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    adj.get(i).add(j);
                }
            }
        }
        int clr[] = new int[n];
        Arrays.fill(clr,-1);
        return helper(0,m,n,clr,adj);
    }

    boolean helper(int src, int m, int n,int clr[], ArrayList<ArrayList<Integer>> adj) {
        if(src==n) return true;
        for(int i=0; i<m; i++){
            if(isPossible(src,adj,clr,i)){
                clr[src]=i;
                if(helper(src+1,m,n,clr,adj)) return true;
                clr[src]=-1;
            }
        }
        return false;
    }
    
    boolean isPossible(int src, ArrayList<ArrayList<Integer>> adj, int clr[], int color){
        for(int child: adj.get(src)){
            if(clr[child]==color) return false;
        }
        return true;
    }
}
