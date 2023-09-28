class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]) q.pollLast();
            q.add(i);
        }
        int n=nums.length;
        int res[]=new int[n-k+1]; int idx=0;
        res[idx++]=nums[q.peekFirst()];
        for(int i=k; i<n; i++){
            while(!q.isEmpty() && q.peekFirst()<=i-k) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]) q.pollLast();
            q.add(i);
            res[idx++]=nums[q.peekFirst()];
        }
        return res;
    }
}
