

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public class Pair{
        int i,j;
        Pair(int i, int j){
            this.i=i; this.j=j;
        }
    }
    
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0; 
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        
        int time = 0;
        int x[]={0,0,1,-1};
        int y[]={-1,1,0,0};
        while(!q.isEmpty()){
            int c = q.size();
            boolean val = false;
            for(int s=0; s<c; s++){
                Pair curr = q.poll();
                int i=curr.i;  int j=curr.j;
                for(int k=0; k<4; k++){
                    int nrow=i+x[k]; int ncol=j+y[k];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        q.add(new Pair(nrow,ncol));
                        cntFresh--;
                        if(!val){
                            time++; val=true;
                        } 
                    }
                }
            }
        }
        if(cntFresh!=0) return -1;
        return time;
    }
}
