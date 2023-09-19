class Solution
{
    int dp[][];
    public int solveWordWrap (int[] nums, int k)
    {
        dp=new int[k+1][nums.length];
        for(int row[]: dp) Arrays.fill(row,-1);
        return helper(k,k,nums,0);
    }
    
    int helper(int spcRmn, int k, int nums[], int idx){
        if(idx>=nums.length) return 0;
        if(dp[spcRmn][idx]!=-1) return dp[spcRmn][idx];
        if(spcRmn==k){
            int res=helper(spcRmn-nums[idx],k,nums,idx+1);
            return dp[spcRmn][idx]=res;
        }else{
            if(spcRmn<nums[idx]+1){
                int res=(spcRmn*spcRmn)+helper(k,k,nums,idx);
                return dp[spcRmn][idx]=res;
            }else{
                int res1=helper(spcRmn-nums[idx]-1,k,nums,idx+1);
                int res2=(spcRmn*spcRmn)+helper(k,k,nums,idx);
                return dp[spcRmn][idx]=Math.min(res1,res2);
            }
        }
    }
}
