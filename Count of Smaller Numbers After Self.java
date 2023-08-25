class Solution {
    int tree[];
    
    int getAns(int left, int right, int qS, int qE, int idx) {
        if (qS > qE) return 0;
        if (left >= qS && right <= qE) return tree[idx];
        int mid = (left + right) / 2;
        int lRes = getAns(left, mid, qS, Math.min(qE, mid), 2 * idx + 1);
        int rRes = getAns(mid + 1, right, Math.max(qS, mid + 1), qE, 2 * idx + 2);
        return lRes + rRes;
    }

    void update(int left, int right, int pos, int idx) {
        if (left == right) {
            tree[idx] += 1;
            return;
        }
        int mid = (left + right) / 2;
        if (pos <= mid) update(left, mid, pos, 2 * idx + 1);
        else update(mid + 1, right, pos, 2 * idx + 2);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        return;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tree = new int[4 * n];
        int prr[][] = new int[n][2];
        for (int i = 0; i < n; i++) prr[i] = new int[] { i, nums[i] };
        Arrays.sort(prr, new Comparator<>(){
            public int compare(int a[], int b[]){ return Integer.compare(a[1], b[1]); };
        });
        int indx[] = new int[n];
        for (int i = 0; i < n; i++) {
            indx[prr[i][0]] = i;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int rightIdx = search(nums[i], prr);
            int res = (rightIdx == n) ? 0 : getAns(0, n - 1, 0, rightIdx, 0);
            ans.add(0, res);
            update(0, n - 1, indx[i], 0);
        }
        return ans;
    }

    int search(int val, int arr[][]) {
        int low = 0; int high = arr.length-1; int res=arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid][1] < val) {
                res=mid;
                low = mid+1;
            } else high = mid - 1;
        }
        return res;
    }
}
