import java.util.* ;
import java.io.*; 

public class Solution {
 
	public static boolean sortArr(int n, int[] arr) {
		int newArr[] = arr.clone();
		Arrays.sort(newArr);
		int first=-1; int second=-1;
		for(int i=0; i<n; i++){
			if(arr[i]!=newArr[i]){
				if(first==-1) first=i;
				else second=i;
			}
		}
		if(first==-1) return true;
		for(int i=first,j=second; i<=second; i++,j--){
			if(arr[i]!=newArr[j]) return false;
		}
		return true;
	}

}
