class Solution {
    int par[]; int size[];
    int findPar(int x){
        if(par[x]==x) return x;
        return par[x]=findPar(par[x]);
    }

    void merge(int x, int y){
        if(size[y]>size[x]){
            int temp=y; y=x; x=temp;
        }
        size[x]+=size[y];
        par[y]=x;
    }

    int dx[] = {-1,1,0,0}; int dy[] = {0,0,-1,1};

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        byte vis[][] = new byte[n][n];
        int len=n*n+n;

        par=new int[len]; size=new int[len];
        for(int i=0; i<len; i++){
            par[i]=i; size[i]=1;
        }

        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set = new HashSet<>();
                    int curRes=1;
                    for(int k=0; k<4; k++){
                        int nI=i+dx[k]; int nJ=j+dy[k];
                        if(isValid(nI,nJ,n) && grid[nI][nJ]==1){
                            int parent=-1;
                            if(vis[nI][nJ]==1){
                                parent=findPar(nI*n+nJ);
                            }else{
                                helper(nI,nJ,vis,grid);
                                parent=findPar(nI*n+nJ);
                            }
                            if(set.add(parent)){
                                curRes+=size[parent];
                            }
                        }
                    }
                    res=Math.max(res,curRes);
                }
            }
        }
        if(res==0) return n*n;
        return res;
    }

    void helper(int row, int col, byte vis[][], int grid[][]){
        vis[row][col]=1;
        int n=grid.length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row,col});
        int parE=findPar(row*n+col);
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int k=0; k<4; k++){
                int nI=cur[0]+dx[k]; int nJ=cur[1]+dy[k];
                if(isValid(nI,nJ,n) && vis[nI][nJ]==0 && grid[nI][nJ]==1){
                    vis[nI][nJ]=1;
                    merge(parE,findPar(nI*n+nJ));
                    q.add(new int[]{nI,nJ});
                }
            }
        }
    }

    boolean isValid(int i, int j, int n){
        if(i>=0 && i<n && j>=0 && j<n) return true;
        return false;
    }
}
