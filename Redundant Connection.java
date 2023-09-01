class Solution {
    int parent[]; int size[];
    int findParent(int x){
        if(parent[x]==x) return x;
        return parent[x]=findParent(parent[x]);
    }
    public void merge(int x, int y){
        if(size[y]>size[x]){
            int temp=x;
            x=y; y=temp;
        }
        size[x]+=size[y];
        parent[y]=x;
        return;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i]=i; size[i]=1;
        }
        for(int edge[]: edges){
            int u=edge[0]; int v=edge[1];
            int lu=findParent(u); int lv=findParent(v);
            if(lu==lv){
                return edge;
            }else{
                merge(lu,lv);
            }
        }
        return new int[2];
    }
}
