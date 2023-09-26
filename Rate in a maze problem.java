

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    
    public ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0){
            res.add("-1");
            return res;
        }
        StringBuilder str = new StringBuilder();
        int vis[][] = new int[n][n]; vis[0][0]=1;
        helper(res,str,0,0,n,m,vis);
        return res;
    }
    
    void helper(ArrayList<String> res, StringBuilder str, int i, int j, int n, int m[][], int vis[][]){
        if(i==n-1 && j==n-1){
            res.add(str.toString());
            return;
        }
        for(int k=0; k<4; k++){
            int row=dx[k]+i; int col=dy[k]+j;
            if(row<n && col<n && row>=0 && col>=0 && vis[row][col]==0 && m[row][col]==1){
                vis[row][col]=1;
                if(k==0) str.append('U');
                else if(k==1) str.append('D');
                else if(k==2) str.append('L');
                else str.append('R');
                helper(res,str,row,col,n,m,vis);
                vis[row][col]=0;
                str.deleteCharAt(str.length()-1);
            }
        }
        return;
    }
}
