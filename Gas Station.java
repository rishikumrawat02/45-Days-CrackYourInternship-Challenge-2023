class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int diff[] = new int[n];
        for(int i=0; i<n; i++) diff[i]=gas[i]-cost[i];
        int sum=0; int res=0;
        for(int i=0; i<n; i++){
            sum+=diff[i];
            if(sum<0){
                res=-1; sum=0;
            }else if(res==-1){
                res=i;
            }
        }
        if(res==-1) return res;
        sum=diff[res];
        for(int i=(res+1)%n; i!=res; i=(i+1)%n){
            sum+=diff[i];
            if(sum<0) return -1;
        }
        return res;
    }
}

// Alternate
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res=0; int curAmount=0; int total=0;
        for(int i=0; i<gas.length; i++){
            total+=gas[i]-cost[i];
            curAmount+=gas[i]-cost[i];
            if(curAmount<0){
                curAmount=0; res=i+1;
            }
        }
        if(total<0 || res==gas.length) return -1;
        return res;
    }
}
