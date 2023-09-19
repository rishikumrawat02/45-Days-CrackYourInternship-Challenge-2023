// Method-1
class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();
        dp=new int[m][n];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        int ans=helper(0,0,m,n,s,t);
        return ans;        
    }

    int helper(int i, int j, int m, int n, String s, String t){
        if(j==n) return 1;
        if(i==m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=0;
        if(s.charAt(i)==t.charAt(j)){
            res=helper(i+1,j+1,m,n,s,t);
        }
        res+=helper(i+1,j,m,n,s,t);
        return dp[i][j]=res;
    }
}

// Method-2
class Solution {    
    public int numDistinct(String s, String t) {
        int m=s.length(); int n=t.length();
        int res[][]=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            res[i][0]=1;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                res[i][j]=res[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)){
                    res[i][j]+=res[i-1][j-1];
                }
            }
        }
        return res[m][n];        
    }
}
