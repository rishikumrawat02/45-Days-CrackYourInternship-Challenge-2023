import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        // int matrix[][]={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int matrix[][] = {{0,1,1},{1,1,1},{0,1,1}};
        int m=matrix.length; int n=matrix[0].length;
        int res=calc(matrix[0],n);
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
            res=Math.max(res,calc(matrix[i],n));
        }
        System.out.println(res);
    }
    
    static int calc(int arr[], int n){
        Stack<Integer> st = new Stack<>();
        int res=0;
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(i);
                res=Math.max(res,arr[i]*(1+i));
                continue;
            }
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()){
                res=Math.max(res,arr[i]*(i+1));
            }else{
                res=Math.max(res,arr[i]*(i-st.peek()));
            }
            st.push(i);
        }
        return res;
    }
}
