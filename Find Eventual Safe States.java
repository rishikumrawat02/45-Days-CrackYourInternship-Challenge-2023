class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int res[] = new int[n];
        int rSt[] = new int[n];
        Arrays.fill(res,-1);
        for(int i=0; i<n; i++){
            if(res[i]==-1){
                Arrays.fill(rSt,0);
                rSt[i]=1;
                helper(i,res,rSt,graph);
            }
            if(res[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }

    int helper(int src, int res[], int rSt[], int graph[][]){
        if(res[src]!=-1) return res[src];
        for(int child: graph[src]){
            if(rSt[child]==1){
                return res[src]=0;
            }else{
                rSt[child]=1;
                int val=helper(child,res,rSt,graph);
                if(val==0){
                    return res[src]=0;
                }
                rSt[child]=0;
            }
        }
        return res[src]=1;
    }
}
