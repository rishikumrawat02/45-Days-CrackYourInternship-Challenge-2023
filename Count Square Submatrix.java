class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length; int n=matrix[0].length; int res=0;
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]==0) continue;
                int maxLen=dp[i-1][j-1];
                int minY=j; int k;
                for(k=j-1; k>=j-maxLen; k--){
                    if(matrix[i-1][k-1]==0){
                        minY=k+1; break;
                    }
                }
                if(k==j-maxLen-1){
                    minY=j-maxLen;
                }
                int minX=i;
                for(k=i-1; k>=i-maxLen; k--){
                    if(matrix[k-1][j-1]==0){
                        minX=k+1; break;
                    }
                }
                if(k==i-maxLen-1){
                    minX=i-maxLen;
                }
                int minLen=Math.min(i-minX+1,j-minY+1);
                dp[i][j]=minLen;
                res+=dp[i][j];                
            }
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return res;
    }
}
