class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        if(nums[0]==0) return false;
        int stepsRmn=nums[0]; int mxRng=nums[0];
        for(int i=1; i<n; i++){
            if(i==n-1) return true;
            mxRng=Math.max(mxRng,i+nums[i]);
            stepsRmn--;
            if(stepsRmn==0){
                stepsRmn=mxRng-i;
                if(stepsRmn<=0) return false;
            }
        }        
        return true;
    }
}
