class Solution {
    public int findTheCity(int n, int[][] edges, int distT) {
        int matrix[][] = new int[n][n];
        for(int row[]: matrix){
            Arrays.fill(row,-1);
        }
        for(int edge[]: edges){
            matrix[edge[0]][edge[1]]=edge[2];
            matrix[edge[1]][edge[0]]=edge[2];
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j){
                        matrix[i][j]=0;
                    }
                    if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    int val = matrix[i][k]+matrix[k][j];
                    if(matrix[i][j]==-1) matrix[i][j]=val;
                    else matrix[i][j]=Math.min(matrix[i][j],val);
                }
            }
        }

        int res=Integer.MAX_VALUE; int ans=-1;
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(matrix[i][j]!=-1 && matrix[i][j]<=distT) cnt++;
            }
            if(cnt<=res){
                res=cnt; ans=i;
            }
        }
        return ans;
    }
}
