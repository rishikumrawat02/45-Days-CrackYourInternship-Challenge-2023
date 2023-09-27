import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int minCashFlow(ArrayList<ArrayList<Integer>> money, int n)
    {
        int netAmnt[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int val=money.get(i).get(j);
                netAmnt[j]+=val; netAmnt[i]-=val;
            }
        } 
        int res[] = {0};
        helper(netAmnt,res);
        return res[0];
    }

    static void helper(int netAmnt[], int res[]){
        int minIdx=0; int maxIdx=0; int n=netAmnt.length;
        for(int i=1; i<n; i++){
            if(netAmnt[i]<netAmnt[minIdx]) minIdx=i;
            if(netAmnt[i]>netAmnt[maxIdx]) maxIdx=i;
        }
        if(netAmnt[minIdx]==0 && netAmnt[maxIdx]==0) return;
        if(Math.abs(netAmnt[minIdx])>=netAmnt[maxIdx]){
            netAmnt[minIdx]+=netAmnt[maxIdx];
            res[0]+=netAmnt[maxIdx];
            netAmnt[maxIdx]=0;
        }else{
            netAmnt[maxIdx]-=Math.abs(netAmnt[minIdx]);
            res[0]+=Math.abs(netAmnt[minIdx]);
            netAmnt[minIdx]=0;
        }
        helper(netAmnt,res);
        return;
    }

    
}
