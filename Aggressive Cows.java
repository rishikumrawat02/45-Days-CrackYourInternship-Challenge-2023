import java.util.*;
public class Solution {
    public static int aggressiveCows(int []arr, int c) {
        // Write your code here.
        Arrays.sort(arr);
        int low=0; int high=(int)1e9; int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(mid,arr,c)){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }

     static boolean isPossible(int mid,int arr[], int c){
        int prevIdx=0; c--;
        for(int i=0; c>0 && i<arr.length; i++){
            if(arr[i]-arr[prevIdx]>=mid){
                prevIdx=i;
                c--;
            }
        }
        return c==0;
    }
}
