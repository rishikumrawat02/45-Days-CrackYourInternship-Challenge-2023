class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxTim=0; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            if(i==headID) continue;
            adj.get(manager[i]).add(i);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{headID,0});
        while(!q.isEmpty()){
            int cur[] = q.poll();
            maxTim=Math.max(maxTim,cur[1]);
            for(int child: adj.get(cur[0])){
                q.add(new int[]{child,cur[1]+informTime[cur[0]]});
            }
        }
        return maxTim;
    }
}
