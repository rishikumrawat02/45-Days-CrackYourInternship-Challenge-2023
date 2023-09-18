// Solution-1
class Solution {
    public int[] restoreArray(int[][] adjP) {
        int n=adjP.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int u=adjP[i][0]; int v=adjP[i][1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v); map.get(v).add(u);
        }
        HashSet<Integer> vis = new HashSet<>();
        int src=adjP[0][0];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(src); vis.add(src);
        helper(map.get(src).get(0),res,map,0,vis);
        if(map.get(src).size()>1){
            helper(map.get(src).get(1),res,map,1,vis);
        }
        int ans[] = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            ans[i]=res.get(i);
        }
        return ans;        
    }

    void helper(int src, ArrayList<Integer> res, HashMap<Integer,ArrayList<Integer>> map, int addFirst, HashSet<Integer> vis){
        vis.add(src);
        if(addFirst==1){
            res.add(0,src);
        }else res.add(src);
        
        for(int child: map.get(src)){
            if(vis.add(child)){
                helper(child,res,map,addFirst,vis);
            }
        }
        return;
    }
}

// Solution-2
class Solution {
    public int[] restoreArray(int[][] adjP) {
        int n=adjP.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int u=adjP[i][0]; int v=adjP[i][1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v); map.get(v).add(u);
        }
        HashSet<Integer> vis = new HashSet<>();
        int src=adjP[0][0];
        for(int key: map.keySet()){
            if(map.get(key).size()==1){
                src=key; break;
            }
        }
        int []res = new int[map.size()]; int i=0; 
        while(!vis.contains(src)){
            res[i++]=src; vis.add(src);
            if(map.get(src).size()==1){
                src=map.get(src).get(0);
            }else{
                if(vis.contains(map.get(src).get(0))){
                    src=map.get(src).get(1);
                }else{
                    src=map.get(src).get(0);
                }
            }
        }
        return res;        
    }
}
