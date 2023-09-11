import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int tugOfWar(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int res[]={Integer.MAX_VALUE};
		int totSum=0;
		for(int val: arr) totSum+=val;
		helper(0,n/2,arr,n,totSum,0,res);
		return res[0];
	}

	static void helper(int idx, int rmn, ArrayList<Integer> arr, int n, int totSum, int curSum, int res[]){
		if(rmn==0){
			res[0]=Math.min(res[0],Math.abs(curSum-(totSum-curSum)));
			return;
		}
		if(idx==n) return;
		helper(idx+1,rmn,arr,n,totSum,curSum,res);
		helper(idx+1,rmn-1,arr,n,totSum,curSum+arr.get(idx),res);
		return;
	}
}
