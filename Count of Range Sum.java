class Solution {
    int res = 0;
    long prefSum[];
    int low;
    int upp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        prefSum = new long[n + 1];
        prefSum[0] = nums[0] * 1L;
        this.low = lower;
        this.upp = upper;
        for (int i = 0; i < n; i++) prefSum[i + 1] = prefSum[i] + nums[i];
        mergeSort(0, n);
        return res;
    }

    void mergeSort(int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int lowIdx = mid + 1;
        int uppIdx = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (lowIdx <= r && prefSum[lowIdx] - prefSum[i] < low) lowIdx++;
            while (uppIdx <= r && prefSum[uppIdx] - prefSum[i] <= upp) uppIdx++;
            res += (uppIdx - lowIdx);
        }
        merge(l, r);
        return;
    }

    void merge(int l, int r) {
        int mid = (l + r) / 2;
        long arr[] = new long[r - l + 1];
        for (int i = l; i <= r; i++) {
            arr[i - l] = prefSum[i];
        }

        int i = 0;
        int j = mid - l + 1; // Adjusted index for the right subarray
        int idx = l; // Start index in the original array
        while (i < mid - l + 1 && j <= r - l) {
            if (arr[i] <= arr[j]) {
                prefSum[idx++] = arr[i++];
            } else {
                prefSum[idx++] = arr[j++];
            }
        }
        while (i < mid - l + 1) {
            prefSum[idx++] = arr[i++];
        }
        while (j <= r - l) {
            prefSum[idx++] = arr[j++];
        }
        return;
    }
}
