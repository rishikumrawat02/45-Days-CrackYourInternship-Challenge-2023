class Solution {
    public int minMoves(int[] nums) {
        int totalSum=0; int minNum=nums[0];
        for(int val: nums){
            totalSum+=val; minNum=Math.min(minNum,val);
        }
        return totalSum-minNum*nums.length;
    }
}
