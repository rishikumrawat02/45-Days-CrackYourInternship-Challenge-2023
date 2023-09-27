

//User function Template for Java

class Solution {
   public boolean isPossible(int V, int[][] prerequisites)
   {
       // Your Code goes here
       int indegree[]=new int[V];
       ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
       
       //converting it to arraylist format for my comfort
       for(int i=0;i<V;i++)
           adj.add(new ArrayList<>());
       
       int n=prerequisites.length;
       for(int i=0;i<n;i++){
           adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
       }
       
       //getting indegrees
       for(int i=0;i<V;i++){
           for(int it:adj.get(i)){
               indegree[it]++;
           }
       }
       
       //adding indegree with initial 0 in queue
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<V;i++){
           if(indegree[i]==0)
               q.add(i);
               
       }
       
       
       ArrayList<Integer> res=new ArrayList<>();
       while(!q.isEmpty()){
           int node=q.peek();
           q.remove();
           res.add(node);
           for(int it:adj.get(node)){
               indegree[it]--;
               
               if(indegree[it]==0)
                   q.add(it);
           }
           
       }
       
       if(res.size()==V)
           return true;
       
       return false;
       
       
   }
   
}
