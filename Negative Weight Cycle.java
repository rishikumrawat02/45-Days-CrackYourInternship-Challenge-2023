class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=1; i<n; i++){
            for(int e[]: edges){
                if(dist[e[0]]!=Integer.MAX_VALUE && dist[e[1]]>dist[e[0]]+e[2]){
                    dist[e[1]]=dist[e[0]]+e[2];
                }
            }
        }
        for(int e[]: edges){
            if(dist[e[1]]>dist[e[0]]+e[2]){
                return 1;
            }
        }
        return 0;
    }
}
