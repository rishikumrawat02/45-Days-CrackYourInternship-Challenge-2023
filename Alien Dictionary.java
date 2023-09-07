class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<n-1; i++){
            int j=i+1;
            for(int k1=0; k1<Math.min(dict[i].length(),dict[j].length()); k1++){
                if(dict[i].charAt(k1)!=dict[j].charAt(k1)){
                    adj.get(dict[i].charAt(k1)-'a').add(dict[j].charAt(k1)-'a');
                    break;
                }
            }
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int indeg[] = new int[k];
        for(int i=0; i<k; i++){
           for(int child: adj.get(i)){
               indeg[child]++;
           }
        }
        
        for(int i=0; i<k; i++){
            if(indeg[i]==0) q.add(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            list.add(cur);
            for(int child: adj.get(cur)){
                indeg[child]--;
                if(indeg[child]==0) q.add(child);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0; i<k; i++){
            res.append((char)(list.get(i) + 'a'));
        }
    
        return res.toString();
    }
}
