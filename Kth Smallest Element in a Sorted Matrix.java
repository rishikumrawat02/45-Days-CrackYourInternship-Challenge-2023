class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0; i<n; i++) pq.add(new int[]{i,0,matrix[i][0]});
        for(int i=0; i<k-1; i++){
            int cur[] = pq.poll();
            if(cur[1]==n-1) continue;
            pq.add(new int[]{cur[0],cur[1]+1,matrix[cur[0]][cur[1]+1]});
        }
        return pq.poll()[2];
    }
}
