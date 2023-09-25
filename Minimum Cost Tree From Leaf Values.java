class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int dp[][] = new int[n][n];
        for(int row[]: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++){
            dp[i][i]=0;
        }
        for(int gap=1; gap<n; gap++){
            for(int i=0, j=gap; j<n; i++,j++){
                for(int k=i; k<j; k++){
                    int res=dp[i][k]+dp[k+1][j];
                    int lMax=-1; int rMax=-1;
                    for(int m=i; m<=k; m++){
                        lMax=Math.max(lMax,arr[m]);
                    }
                    for(int m=k+1; m<=j; m++){
                        rMax=Math.max(rMax,arr[m]);
                    }
                    res+=(lMax*rMax);
                    dp[i][j]=Math.min(dp[i][j],res);
                }                
            }
        }

        return dp[0][n-1];
    }
}
