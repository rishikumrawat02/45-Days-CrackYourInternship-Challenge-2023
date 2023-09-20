class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums); int n=nums.length;
        int firstProd=nums[0]*nums[1]*nums[n-1];
        return Math.max(firstProd,nums[n-1]*nums[n-2]*nums[n-3]);
    }
}
