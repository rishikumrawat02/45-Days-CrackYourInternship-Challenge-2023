class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0; int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long left=(mid-1>=0)?nums[mid-1]:Long.MIN_VALUE;
            long right=(mid+1<n)?nums[mid+1]:Long.MIN_VALUE;
            if(nums[mid]>left && nums[mid]>right) return mid;
            else if(right>nums[mid]){
               low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
