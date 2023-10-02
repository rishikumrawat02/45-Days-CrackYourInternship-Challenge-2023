import java.util.* ;
import java.io.*; 
public class Solution{
    static class Job implements Comparable<Job>{
        int start; int end; int profit;
        Job(int start, int end, int profit){
            this.start=start; this.end=end; this.profit=profit;
        }
        public int compareTo(Job j){
            return this.start-j.start;
        }
    }

    public static long findMaxProfit(int[] start, int[] end, int[] profit){
        int n=profit.length;
        Job arr[] = new Job[n];
        for(int i=0; i<n; i++){
            arr[i]=new Job(start[i],end[i],profit[i]);
        }
        Arrays.sort(arr);

        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return helper(0,arr,dp);
    }

    public static long helper(int idx, Job arr[], long dp[]){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        long exclude=helper(idx+1,arr,dp);
        int nextIdx=arr.length;
        for(int i=idx+1; i<arr.length; i++){
            if(arr[i].start>=arr[idx].end){
                nextIdx=i; break;
            }
        }
        long include=arr[idx].profit*1l+helper(nextIdx,arr,dp);
        return dp[idx]=Math.max(exclude,include);
    }
}
