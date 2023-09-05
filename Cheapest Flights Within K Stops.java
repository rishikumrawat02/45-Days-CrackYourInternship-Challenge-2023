class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>>adj =  new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int flight[]: flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int dist[]=new int[n];
        dist[src]=0;
        Arrays.fill(dist,Integer.MAX_VALUE);

        q.add(new int[]{src,0,k});
        int res=Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int cur[]=q.poll();
            if(cur[0]==dst){
                res=Math.min(res,cur[1]);
                continue;
            }
            if(cur[2]<0) continue;

            for(int child[]: adj.get(cur[0])){
                if(dist[child[0]]>cur[1]+child[1]){
                    dist[child[0]]=cur[1]+child[1];
                    q.add(new int[]{child[0],dist[child[0]],cur[2]-1});
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
