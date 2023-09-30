class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {         
            for (int k = 0; k < coins.length; k++) {
                if (coins[k] <= i) {
                     dp[i] = Math.min(dp[i - coins[k]] + 1, dp[i]);
                }  
            }
        }   
        return dp[amount] > amount ? - 1 : dp[amount];
    }
    
}
