class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int m=grid.length; int n=grid[0].length;
        int res[][] = new int[m][n];
        for(int row[]: res){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    res[i][j]=0; q.add(new int[]{i,j});
                }
            }
        }
        
        int dx[]={-1,1,0,0}; int dy[]={0,0,-1,1};
        
        while(!q.isEmpty()){
            int cur[]=q.poll();
            for(int i=0; i<4; i++){
                int row=cur[0]+dx[i]; int col=cur[1]+dy[i];
                if(row>=0 && row<m && col>=0 && col<n && res[row][col]>res[cur[0]][cur[1]]+1){
                    res[row][col]=res[cur[0]][cur[1]]+1;
                    q.add(new int[]{row,col});
                }
            }
        }
        
        return res;
    }
}
