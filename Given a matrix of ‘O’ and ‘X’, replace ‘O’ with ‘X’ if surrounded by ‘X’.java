import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        // int matrix[][]={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        char matrix[][] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                            {'X', 'O', 'X', 'X', 'O', 'X'},
                            {'X', 'X', 'X', 'O', 'O', 'X'},
                            {'O', 'X', 'X', 'X', 'X', 'X'},
                            {'X', 'X', 'X', 'O', 'X', 'O'},
                            {'O', 'O', 'X', 'O', 'O', 'O'}};
        int m=matrix.length; int n=matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='O'){
                    matrix[i][j]='-';
                }
            }
        }
        for(int i=0; i<m; i++){
            if(matrix[i][0]=='-'){
                matrix[i][0]='O';
                helper(i,0,matrix);
            }
            if(matrix[i][n-1]=='-'){
                matrix[i][n-1]='O';
                helper(i,n-1,matrix);
            }
        }
        
        for(int j=0; j<n; j++){
            if(matrix[0][j]=='-'){
                matrix[0][j]='O';
                helper(0,j,matrix);
            }
            if(matrix[m-1][j]=='-'){
                matrix[m-1][j]='O';
                helper(m-1,j,matrix);
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='-'){
                    matrix[i][j]='X';
                }
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static int dx[] = {-1,-1,-1,1,1,1,0,0};
    static int dy[] = {0,-1,1,0,-1,1,-1,1};
    
    static void helper(int i, int j, char matrix[][]){
        for(int k=0; k<8; k++){
            int nI=i+dx[k]; int nJ=j+dy[k];
            if(nI>=0 && nJ>=0 && nI<matrix.length && nJ<matrix[0].length && matrix[nI][nJ]=='-'){
                matrix[nI][nJ]='O';
                helper(nI,nJ,matrix);
            }
        }
        return;
    }
}
