class Solution {
    public void gameOfLife(int[][] board) {
        int dx[] = {-1,1,0,0,-1,-1,1,1};
        int dy[] = {0,0,-1,1,-1,1,-1,1};
        int m=board.length; int n=board[0].length;
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cnt=0;
                for(int k=0; k<8; k++){
                    int row=i+dx[k]; int col=dy[k]+j;
                    if(row>=0 && col>=0 && row<m && col<n && (board[row][col]==1 || board[row][col]==-1)) cnt++;
                }
                if(board[i][j]==0 &&  cnt==3){
                    board[i][j]=2;
                }else if(board[i][j]==1){
                    if(cnt<2 || cnt>3){
                        board[i][j]=-1;
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2) board[i][j]=1;
                else if(board[i][j]==-1) board[i][j]=0;
            }
        }
        return;
    }
}
