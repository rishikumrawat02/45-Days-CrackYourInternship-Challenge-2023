class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return Integer.compare(b[0],a[0]);
            }
        });
        pq.add(new int[]{points[0][1]-points[0][0],points[0][0]});
        int res=Integer.MIN_VALUE; int n=points.length;
        for(int i=1; i<n; i++){
            while(!pq.isEmpty() && points[i][0]-pq.peek()[1]>k) pq.poll();
            if(!pq.isEmpty()){
                res=Math.max(res,pq.peek()[0]+points[i][0]+points[i][1]);
            }
            pq.add(new int[]{points[i][1]-points[i][0],points[i][0]});
        }
        return res;
    }
}
