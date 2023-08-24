class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double p1p2=dist(p1,p2);
        double p1p3=dist(p1,p3);
        double p1p4=dist(p1,p4);
        double p2p3=dist(p2,p3);
        double p2p4=dist(p2,p4);
        double p3p4=dist(p3,p4);
        HashSet<Double> set = new HashSet<>();
        set.add(p1p2); set.add(p1p3); set.add(p1p4); set.add(p2p3); set.add(p2p4); set.add(p3p4);
        if(set.contains(0.0)) return false;
        return set.size()==2;
    }

    double dist(int a[], int b[]){
        int x1=a[0]; int y1=a[1];
        int x2=b[0]; int y2=b[1];
        int xSqr = (x1-x2)*(x1-x2);
        int ySqr = (y1-y2)*(y1-y2);
        double val=Math.sqrt((xSqr+ySqr));
        return val;
    }
}
