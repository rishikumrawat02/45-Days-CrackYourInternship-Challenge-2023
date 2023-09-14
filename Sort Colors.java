class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0; int right=n-1;
        int i=0;
        while(i<=right){
            if(i<left){
                i++; continue;
            }
            if(nums[i]==0){
                nums[i]=nums[left];
                nums[left]=0; left++;
            }else if(nums[i]==2){
                nums[i]=nums[right];
                nums[right]=2; right--;
            }else i++;
        }
        return;
    }
}
