

class Solution {
    // Function to detect cycle in an undirected graph.
    
    boolean DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited, int parent){
        visited[s] = true;
        for(int adjacent: adj.get(s)){
            if(!visited[adjacent]){
               if(DFSRec(adj,adjacent,visited,s)) return true;;
            }else if(adjacent!=parent){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(DFSRec(adj,i,visited,-1)) return true;
            }
        }
        return false;
    }
}
