class Solution {

    public int removeStones(int[][] stones) {
        int n=stones.length;
        int vis[] = new int[n];
        HashMap<Integer,ArrayList<Integer>> row= new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> col= new HashMap<>();
        for(int i=0; i<n; i++){
            int x=stones[i][0]; int y=stones[i][1];
            row.putIfAbsent(x,new ArrayList<>());
            col.putIfAbsent(y,new ArrayList<>());
            row.get(x).add(i); col.get(y).add(i);
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                cnt++;
                helper(stones[i][0],stones[i][1],i,row,col,vis,stones);
            }
        }
        return n-cnt;
    }

    void helper(int x, int y, int idx, HashMap<Integer,ArrayList<Integer>> row, HashMap<Integer,ArrayList<Integer>> col, int vis[],int stones[][]){
        vis[idx]=1;
        for(Integer key: row.get(x)){
            if(vis[key]==0){
                helper(stones[key][0],stones[key][1],key,row,col,vis,stones);
            }
        }
        for(Integer key: col.get(y)){
            if(vis[key]==0){
                helper(stones[key][0],stones[key][1],key,row,col,vis,stones);
            }
        }
        return;
    }
}
