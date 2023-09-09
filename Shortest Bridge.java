class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};

    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int vis[][] = new int[n][n]; boolean found=false;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(found) break;
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    markVis(grid,vis,q,i,j);
                    found=true; break;
                }
            }
        }

        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int k=0; k<4; k++){
                int nI=cur[0]+dx[k]; int nJ=cur[1]+dy[k];
                if(nI>=0 && nI<n && nJ>=0 && nJ<n && vis[nI][nJ]==0){
                    if(grid[nI][nJ]==1){
                        return cur[2];
                    }
                    q.add(new int[]{nI,nJ,cur[2]+1});
                    vis[nI][nJ]=1;
                }
            }
        }

        return n;        
    }

    void markVis(int grid[][], int vis[][], ArrayDeque<int[]> q, int row, int col){
        vis[row][col]=1;
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{row,col}); q.add(new int[]{row,col,0});
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            for(int k=0; k<4; k++){
                int nI=cur[0]+dx[k]; int nJ=cur[1]+dy[k];
                if(nI>=0 && nJ>=0 && nI<grid.length && nJ<grid.length && grid[nI][nJ]==1 && vis[nI][nJ]==0){
                    vis[nI][nJ]=1;
                    pq.add(new int[]{nI,nJ}); q.add(new int[]{nI,nJ,0});
                }
            }
        }
        return;
    }
}
