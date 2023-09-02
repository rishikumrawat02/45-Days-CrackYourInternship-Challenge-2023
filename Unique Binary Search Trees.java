class Solution {
    int dp[];
    public int numTrees(int n) {
        dp=new int[n+3];
        Arrays.fill(dp,-1);
        return helper(n);
    }

    int helper(int n){
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int res=0;
        for(int i=1; i<=n; i++){
            int left=helper(i-1);
            int right=helper(n-i);
            res+=left*right;
        }
        return dp[n]=res;
    }

}
