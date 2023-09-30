

//User function Template for Java

class Solution{
    
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];
        // for(int i=1;i<=m; i++){
        //     if(s1.charAt(0)==s2.charAt(i-1)){
        //         dp[1][i]=1;
        //     }
        //     if(s2.charAt(0)==s1.charAt(i-1)){
        //         dp[i][1]=1;
        //     }
        // }
        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
