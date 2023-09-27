class Solution {
    class Pair{
        double cost; String v;
        Pair(double cost, String v){this.cost=cost; this.v=v;};
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,ArrayList<Pair>> map = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(new Pair(values[i],v));
            map.get(v).add(new Pair(1.00/values[i],u));
        }

        double res[] = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String u=queries.get(i).get(0); String v=queries.get(i).get(1);
            if(!map.containsKey(u) || !map.containsKey(v)){
                res[i]=-1.00;
                continue;
            }

            ArrayDeque<Pair> q = new ArrayDeque<>(); q.add(new Pair(1.00,u));
            HashSet<String> visited=new HashSet<>(); visited.add(u);
            boolean found=false;
            while(!q.isEmpty()){
                Pair cur = q.poll();
                if(cur.v.equals(v)){
                    res[i]=cur.cost;
                    found=true;
                    break;
                }
                if(!map.containsKey(cur.v)) continue;
                for(Pair child: map.get(cur.v)){
                    if(visited.contains(child.v)) continue;
                    visited.add(cur.v);
                    q.add(new Pair(cur.cost*child.cost,child.v));
                }
            }
            if(!found){
                res[i]=-1.00;
            }
        }

        return res;
    }
}
