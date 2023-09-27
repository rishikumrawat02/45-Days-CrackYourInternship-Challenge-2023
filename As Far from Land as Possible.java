class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int dist[][] = new int[n][n];
        for(int row[]: dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    dist[i][j]=0;
                }
            }
        }
        int dx[]={-1,1,0,0}; int dy[]={0,0,-1,1};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int k=0; k<4; k++){
                int i=cur[0]+dx[k]; int j=cur[1]+dy[k];
                if(i>=0 && j>=0 && i<n && j<n && dist[i][j]>dist[cur[0]][cur[1]]+1){
                    dist[i][j]=dist[cur[0]][cur[1]]+1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int res=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0 && dist[i][j]!=Integer.MAX_VALUE){
                    res=Math.max(res,dist[i][j]);
                }
            }
        }
        return res;
    }
}
