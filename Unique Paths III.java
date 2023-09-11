class Solution {
    int res=0;
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};

    public int uniquePathsIII(int[][] grid) {
        int m=grid.length; int n=grid[0].length;
        int vis[][] = new int[m][n];
        int start[] = new int[2]; 
        int end[] = new int[2]; 
        int total=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    start[0]=i; start[1]=j;
                }else if(grid[i][j]==2){
                    end[0]=i; end[1]=j;
                }
                if(grid[i][j]!=-1) total++;
            }
        }
        
        helper(grid,m,n,vis,total-1,start[0],start[1],end);
        return res;
    }

    void helper(int grid[][], int m, int n, int vis[][], int total, int row, int col, int end[]){
        if(row==end[0] && col==end[1]){
            if(total==0) res++; 
            return;
        }
        vis[row][col]=1;
        for(int k=0; k<4; k++){
            int nRow=dx[k]+row; int nCol=dy[k]+col;
            if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && vis[nRow][nCol]==0 && grid[nRow][nCol]!=-1){
                helper(grid,m,n,vis,total-1,nRow,nCol,end);
            }
        }
        vis[row][col]=0;
        return;
    }

}
