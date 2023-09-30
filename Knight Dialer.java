class Solution {
    long dp[][][]; int mod=(int)1e9+7;
    public int knightDialer(int n) {
        dp = new long[4][4][5001];
        for(long row[][]: dp){
            for(long col[]: row){
                Arrays.fill(col,-1);
            }
        }

        long res=0l;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                res+=helper(i,j,n-1); res%=mod;
            }
        }
        res+=helper(3,1,n-1); res%=mod;
        return (int)res;        
    }

    long helper(int i, int j, int n){
        if(n==0) return 1l;
        if(dp[i][j][n]!=-1) return dp[i][j][n];
        int dx[] = {-2,-2,2,2,-1,1,-1,1};
        int dy[] = {-1,1,-1,1,-2,-2,2,2};
        long res=0l;
        for(int k=0; k<8; k++){
            int ni=dx[k]+i; int nj=j+dy[k];
            if(isValid(ni,nj)){
                res+=helper(ni,nj,n-1); res%=mod;
            }
        }
        return dp[i][j][n]=res;
    }

    boolean isValid(int i, int j){
        if(i>=0 && j>=0 && i<=2 && j<=2) return true;
        else if(i==3 && j==1) return true;
        return false;
    }
}
