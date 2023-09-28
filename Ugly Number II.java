class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> vis = new HashSet<>();
        pq.add(1l); vis.add(1l);
        while(n>1){
            long cur=pq.poll(); n--;
            if(vis.add(cur*2l)) pq.add(cur*2l);
            if(vis.add(cur*3l)) pq.add(cur*3l);
            if(vis.add(cur*5l)) pq.add(cur*5l);
        }
        long res=pq.poll();
        return (int)res;
    }
}
