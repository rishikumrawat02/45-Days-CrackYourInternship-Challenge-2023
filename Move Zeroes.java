class Solution {
    public void moveZeroes(int[] nums) {
        int i=0; int j=0; 
        int n=nums.length;
        while(i<n && j<n){
           if(nums[i]==0){
               System.out.println(i);
               while(j<n && nums[j]==0) j++;
               if(j<n) {
                   nums[i]=nums[j];
                   nums[j]=0;
               }               
           }
           i++;
           if(j<i) j=i;
        }
        return;
    }
}
