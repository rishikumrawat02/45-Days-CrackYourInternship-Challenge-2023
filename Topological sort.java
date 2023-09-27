

/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int indeg[] = new int[v];
        for(int i=0; i<v; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                indeg[adj.get(i).get(j)]++;
            }
        }
        int res[] = new int[v]; int idx=0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<v; i++){
            if(indeg[i]==0){
                q.add(i);
                res[idx++]=i;
            } 
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            for(Integer adjNode: adj.get(cur)){
                indeg[adjNode]--;
                if(indeg[adjNode]==0){
                    q.add(adjNode); res[idx++]=adjNode;
                }
            }
            
        }
        return res;
    }
}
