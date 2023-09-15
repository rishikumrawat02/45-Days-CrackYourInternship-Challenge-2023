class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int n=prices.length; 
        dp=new int[n][2];
        for(int row[]: dp) Arrays.fill(row,-1);
        return helper(0,0,prices,n);
    }

    int helper(int isBuy, int idx, int prices[], int n){
        if(idx==n) return 0;
        if(dp[idx][isBuy]!=-1) return dp[idx][isBuy];
        if(isBuy==0){
            int skip=helper(0,idx+1,prices,n);
            int take=helper(1,idx+1,prices,n)-prices[idx];
            return dp[idx][isBuy]=Math.max(skip,take);
        }else{
            int skip=helper(1,idx+1,prices,n);
            int take=helper(0,idx+1,prices,n)+prices[idx];
            return dp[idx][isBuy]=Math.max(skip,take);
        }
        
    }
}
