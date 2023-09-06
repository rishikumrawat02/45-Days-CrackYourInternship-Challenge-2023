class Solution {
    int dp[][];
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};

    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length; int n=matrix[0].length;
        dp = new int[m][n]; int res=0;
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int curRes=helper(i,j,m,n,matrix);
                res=Math.max(res,curRes+1);
            }
        }
        return res;
    }

    int helper(int row, int col, int m, int n, int matrix[][]){
        if(dp[row][col]!=-1) return dp[row][col];
        int res=0;
        for(int k=0; k<4; k++){
            int nI=row+dx[k]; int nJ=col+dy[k];
            if(nI>=0 && nI<m && nJ>=0 && nJ<n && matrix[nI][nJ]>matrix[row][col]){
                int curRes=helper(nI,nJ,m,n,matrix);
                res=Math.max(res,curRes+1);
            }
        }
        return dp[row][col]=res;
    }
}
