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
        int res=0;
        for(int i=0; i<n; i++){
            if(netAmnt[i]>0){
                res+=netAmnt[i];
            }
        }
        return res;
    }    
}
