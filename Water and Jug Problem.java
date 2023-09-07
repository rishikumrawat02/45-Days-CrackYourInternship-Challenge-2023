class Solution {
    class Pair{
        int jug1; int jug2;
        Pair(int jug1, int jug2){
            this.jug1=jug1; this.jug2=jug2;
        }
    }
    public boolean canMeasureWater(int cap1, int cap2, int target) {
        HashSet<String> vis = new HashSet<>();
        vis.add("0,0");
        ArrayDeque<Pair> q = new ArrayDeque<>();
        Pair root = new Pair(0,0);
        q.add(root);
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.jug1==target || cur.jug2==target || cur.jug1+cur.jug2==target){
                return true;
            }

            Pair p;

            // jug-1 empty jug-2 full
            if(!vis.contains(0+","+cap2)){
                p = new Pair(0,cap2);
                vis.add(0+","+cap2);
                q.add(p);
            }

            // jug-1 full jug-2 empty
            if(!vis.contains(cap1+","+0)){
                p = new Pair(cap1,0);                
                vis.add(cap1+","+0);
                q.add(p);
            }

            // jug-1 empty jug-2 untouched
            if(!vis.contains(0+","+cur.jug2)){
                p = new Pair(0,cur.jug2);
                vis.add(0+","+cur.jug2);
                q.add(p);
            }

            // jug-1 untouched jug-2 empty
            if(!vis.contains(cur.jug1+","+0)){
                p = new Pair(cur.jug1,0);
                vis.add(cur.jug1+","+0);
                q.add(p);
            }

            // jug-1 full jug-2 untouched
            if(!vis.contains(cap1+","+cur.jug2)){
                p = new Pair(cap1,cur.jug2);
                vis.add(cap1+","+cur.jug2);
                q.add(p);
            }

            // jug-1 untouched jug-2 full
            if(!vis.contains(cur.jug1+","+cap2)){
                p = new Pair(cur.jug1,cap2);
                vis.add(cur.jug1+","+cap2);
                q.add(p);
            }

            // Transferring water from jug1 to jug2
            int req = cap2-cur.jug2;
            int transfered = Math.min(cur.jug1,req);
            if(!vis.contains((cur.jug1-transfered)+","+(cur.jug2+transfered))){
                p = new Pair(cur.jug1-transfered,cur.jug2+transfered);
                vis.add((cur.jug1-transfered)+","+(cur.jug2+transfered));
                q.add(p);
            }
            
            // Transferring water from jug2 to jug1
            req = cap1-cur.jug1;
            transfered = Math.min(cur.jug2,req);
            if(!vis.contains((cur.jug1+transfered)+","+(cur.jug2-transfered))){
                p = new Pair(cur.jug1+transfered,cur.jug2-transfered);
                vis.add((cur.jug1+transfered)+","+(cur.jug2-transfered));
                q.add(p);
            }

        }
        return false;
    }
}
