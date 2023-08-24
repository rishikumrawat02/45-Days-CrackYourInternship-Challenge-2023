class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Double,Integer> map = new HashMap<>();
        int n=points.length;

        int res=1;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                double slope=calc(points[i],points[j]);
                map.put(slope,map.getOrDefault(slope,1)+1);
            }
            for(Double key: map.keySet()){
                res=Math.max(res,map.get(key));
            }
            map.clear();
        }
        return res;      
    }

    double calc(int a[], int b[]){
        int x1=a[0]; int y1=a[1];
        int x2=b[0]; int y2=b[1];
        if(x1==x2){
            return Double.MAX_VALUE;
        }
        if(y1==y2) return 0.0;
        double slope=(y2*1.00-y1)/(x2*1.00-x1);
        return slope;
    }
}
