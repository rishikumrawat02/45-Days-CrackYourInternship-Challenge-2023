class Solution {
    public int eraseOverlapIntervals(int[][] interval) {
        Arrays.sort(interval,(a,b)->a[1]-b[1]);
        int n=interval.length;
        int prev=0; int cnt=0;
        for(int i=1; i<n; i++){
            if(interval[prev][1]>interval[i][0]){
                cnt++; continue;
            } 
            else prev=i;
        }
        return cnt;
    }
}
