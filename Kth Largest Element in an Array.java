class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right)
            return nums[left];

        int pivotIndex = (int) (Math.random() * (right - left + 1) + left);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if(k == nums.length - pivotIndex)
            return nums[pivotIndex];
        else if (k < nums.length - pivotIndex)
            return quickSelect(nums, pivotIndex + 1, right, k);
        else
            return quickSelect(nums, left, pivotIndex - 1, k);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
            int pivotValue = nums[pivotIndex];
            swap(nums, pivotIndex, right);
            int storeIndex = left;
            for(int i = left; i <= right; i++) {
                if(nums[i] < pivotValue) {
                    swap(nums, i, storeIndex);
                    storeIndex++;
                }
            }
            swap(nums, storeIndex, right);
            return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
