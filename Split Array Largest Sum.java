class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0; int high=0; int res=0;
        for(int val:nums) high+=val;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(mid,nums,k)){
                res=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return res;
    }

    boolean isPossible(int maxSum, int nums[], int k){
        int sum=0; int ppl=1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>maxSum) return false;
            if(sum+nums[i]<=maxSum){
                sum+=nums[i];
            }else{
                sum=nums[i];
                ppl++;
            }
        }
        return ppl<=k;
    }
}
