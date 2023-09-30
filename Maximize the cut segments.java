class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1); dp[0]=0;
       for(int i=1; i<=n; i++){
           if(i-x>=0 && dp[i-x]!=-1) dp[i]=Math.max(dp[i],dp[i-x]+1);
           if(i-y>=0 && dp[i-y]!=-1) dp[i]=Math.max(1+dp[i-y],dp[i]);
           if(i-z>=0 && dp[i-z]!=-1) dp[i]=Math.max(1+dp[i-z],dp[i]);
       }
       return dp[n]!=-1?dp[n]:0;
    }
}
