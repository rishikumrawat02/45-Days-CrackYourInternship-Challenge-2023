class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            }
        });
        for(int i=0; i<=n-k; i++){
            pq.add(new int[]{nums[i],i});
        }
        int res[] = new int[k]; int idx=0; int nextIdx=n-k+1;
        while(k>0){
            res[idx++]=pq.poll()[1];
            if(nextIdx<n) pq.add(new int[]{nums[nextIdx],nextIdx++});
            while(!pq.isEmpty() && pq.peek()[1]<res[idx-1]) pq.poll();
            k--;
        }
        for(int i=0; i<res.length; i++){
            res[i]=nums[res[i]];
        }
        return res;
    }
}
