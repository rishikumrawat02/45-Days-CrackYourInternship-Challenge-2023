
class Solution
{
    long dp[][][]; 
	public long getCount(int n)
	{
		dp = new long[4][4][26];
        for(long row[][]: dp){
            for(long col[]: row){
                Arrays.fill(col,-1);
            }
        }

        long res=0l;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                res+=helper(i,j,n-1);
            }
        }
        res+=helper(3,1,n-1); 
        return res;        
	}
	
	long helper(int i, int j, int n){
        if(n==0) return 1l;
        if(dp[i][j][n]!=-1) return dp[i][j][n];
        int dx[] = {-1,1,0,0,0};
        int dy[] = {0,0,-1,1,0};
        long res=0l;
        for(int k=0; k<5; k++){
            int ni=dx[k]+i; int nj=j+dy[k];
            if(isValid(ni,nj)){
                res+=helper(ni,nj,n-1);
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
