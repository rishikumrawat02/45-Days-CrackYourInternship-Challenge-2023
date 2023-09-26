class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean visited[] = new boolean[V];
        visited[0]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            res.add(cur);
            for(int child: adj.get(cur)){
                if(visited[child]==false){
                    q.add(child);
                    visited[child]=true;
                }
            }
        }
        return res;
    }
}
