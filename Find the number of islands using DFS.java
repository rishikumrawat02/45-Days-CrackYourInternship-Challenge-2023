import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        // int matrix[][]={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int matrix[][] =  {{1, 1, 0, 0, 0},{0, 1, 0, 0, 1},
                           {1, 0, 0, 1, 1},{0, 0, 0, 0, 0},
                           {1, 0, 1, 0, 0}};
        int m=matrix.length; int n=matrix[0].length;
        int vis[][] = new int[m][n]; int res=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1 && vis[i][j]==0){
                    res++; vis[i][j]=1;
                    helper(i,j,vis,matrix);
                }
            }
        }
        System.out.println(res);
    }
    
    static int dx[] = {-1,-1,-1,1,1,1,0,0};
    static int dy[] = {0,-1,1,0,-1,1,-1,1};
    
    static void helper(int i, int j, int vis[][], int matrix[][]){
        for(int k=0; k<8; k++){
            int nI=i+dx[k]; int nJ=j+dy[k];
            if(nI>=0 && nJ>=0 && nI<matrix.length && nJ<matrix[0].length && matrix[nI][nJ]==1 && vis[nI][nJ]==0){
                vis[nI][nJ]=1;
                helper(nI,nJ,vis,matrix);
            }
        }
        return;
    }
}
