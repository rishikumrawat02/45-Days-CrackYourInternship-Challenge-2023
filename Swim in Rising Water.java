class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int vis[][] = new int[n][n];
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        vis[0][0]=1; q.add(new int[]{0,0,grid[0][0]});

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        while(!q.isEmpty()){
            int cur[] = q.poll();
            if(cur[0]==n-1 && cur[1]==n-1) return cur[2];
            for(int k=0; k<4; k++){
                int nI=dx[k]+cur[0]; int nJ=dy[k]+cur[1];
                if(nI>=0 && nJ>=0 && nI<n && nJ<n && vis[nI][nJ]==0){
                    vis[nI][nJ]=1; q.add(new int[]{nI,nJ,Math.max(cur[2],grid[nI][nJ])});
                }
            }
        }

        return -1;
    }
}
