class Solution {
    int dp[];
    public int deleteAndEarn(int[] nums) {
        int sum[] = new int[10002];
        for(int i=0; i<nums.length; i++){
            sum[nums[i]]+=nums[i];
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<10002; i++){
            if(sum[i]==0) continue;
            list.add(new int[]{i,sum[i]});
        }
        Collections.sort(list,(a,b)->a[0]-b[0]);
        dp=new int[list.size()];
        Arrays.fill(dp,-1);
        return helper(0,list,list.size());
    }

    int helper(int idx, ArrayList<int[]> list, int n){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int notTake=helper(idx+1,list,n);
        int nextIdx=idx+1;
        if(idx+1<n && list.get(idx+1)[0]==list.get(idx)[0]+1){
            nextIdx=idx+2;
        }
        int take=list.get(idx)[1];
        take+=helper(nextIdx,list,n);
        return dp[idx]=Math.max(notTake,take);
    }
}
