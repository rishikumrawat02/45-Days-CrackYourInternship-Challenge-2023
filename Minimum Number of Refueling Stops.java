lass Solution {
    public int minRefuelStops(int target, int sF, int[][] stations) {
        int curPos=sF; int idx=0; int n=stations.length; int res=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(curPos<target){
            while(idx<n && stations[idx][0]<=curPos) pq.add(stations[idx++][1]);
            if(pq.isEmpty()) break;
            curPos+=pq.poll(); res++;
        }

        return (curPos>=target)?res:-1;
    }
}
