import java.util.*;
import java.io.*;

public class Solution{
  public static void main(String args[]){
    int arr[]={1,2,3,4,5};
    Arrays.sort(arr);
    printCombination(arr,3);
    return;
  }

  static void printCombination(int arr[], int r){
    int n=arr.length;
    int res[] = new int[r];
    helper(arr,n,r,0,0,res);
    return;
  }

  static void helper(int arr[], int n, int r, int i, int index, int res[]){
    if(index==r){
      for(int j=0; j<r; j++){
        System.out.print(res[j]+" ");
      }
      System.out.println();
      return;
    }
    if(i>=n) return;
    while(i+1<n && arr[i]==arr[i+1]){
      i++;
    }
    
    //take
    res[index]=arr[i];
    helper(arr,n,r,i+1,index+1,res);

    //not take
    helper(arr,n,r,i+1,index,res);
    return;
  }
}
