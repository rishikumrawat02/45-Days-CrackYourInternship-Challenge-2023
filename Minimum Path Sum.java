class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int m=grid.length; int n=grid[0].length; 
        dp = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

        visited[0][0]=true;

        return helper(0,0,grid,m,n,visited);
    }

    int helper(int i, int j, int [][]grid, int m, int n,boolean visited[][]){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];

        int dx[] = {1,0};
        int dy[] = {0,1};

        int res=Integer.MAX_VALUE;

        for(int k=0; k<2; k++){
            int nI=i+dx[k]; int nJ=j+dy[k];
            if(nI>=0 && nI<m && nJ>=0 && nJ<n && !visited[nI][nJ]){
                visited[nI][nJ]=true;
                res=Math.min(res,helper(nI,nJ,grid,m,n,visited));
                visited[nI][nJ]=false;
            }
        }

        System.out.println(res+" "+i+" "+j);

        return dp[i][j]=(res+grid[i][j]);
    }


}
