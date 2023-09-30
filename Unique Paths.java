class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int row[]: dp) Arrays.fill(row,-1);
        return helper(0,0,m,n);
    }

    int helper(int i, int j, int m, int n){
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=0;
        if(i+1<m){
            res=helper(i+1,j,m,n);
        }
        if(j+1<n){
            res+=helper(i,j+1,m,n);
        }
        return dp[i][j]=res;
    }
}
