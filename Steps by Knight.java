class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int kPos[], int tPos[], int n)
    {
        // Code here
        int vis[][] = new int[n][n];
        for(int row[]: vis) Arrays.fill(row,-1);
        vis[kPos[0]-1][kPos[1]-1]=0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{kPos[0]-1,kPos[1]-1});
        
        int dx[] = {2,2,-2,-2,1,1,-1,-1};
        int dy[] = {1,-1,1,-1,2,-2,2,-2};
        
        while(!q.isEmpty()){
            int cur[]=q.poll();
            if(cur[0]==tPos[0]-1 && cur[1]==tPos[1]-1) return vis[cur[0]][cur[1]];
            for(int k=0; k<8; k++){
                int nI=cur[0]+dx[k];
                int nJ=cur[1]+dy[k];
                if(nI>=0 && nJ>=0 && nI<n && nJ<n && vis[nI][nJ]==-1){
                    vis[nI][nJ]=vis[cur[0]][cur[1]]+1;
                    q.add(new int[]{nI,nJ});
                }
            }
        }
        return -1;
    }
}
