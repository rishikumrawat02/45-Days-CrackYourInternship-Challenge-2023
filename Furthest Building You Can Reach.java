class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        int sum=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<n; i++){
            if(heights[i]<=heights[i-1]) continue;
            int req=heights[i]-heights[i-1];
            pq.add(req);
            if(pq.size()>ladders){
                int val=pq.poll();
                if(sum+val<=bricks){
                    sum+=val;
                }else{
                    return i-1;
                }
            }
        }
        return n-1;
    }
}
