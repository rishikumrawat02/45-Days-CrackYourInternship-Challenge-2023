class Solution {
    public int kthFactor(int n, int k) {
        int cnt=0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0) cnt++;
            if(cnt==k) return i;
        }
        int totalFact=2*cnt;
        int sqrt=(int)Math.sqrt(n);
        if((sqrt*sqrt)==n) totalFact--;
        if(k>totalFact) return -1;
        int complementPos=totalFact-k+1;
        int pos=0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                pos++;
            }
            if(pos==complementPos) return n/i;
        }
        return -1;
    }
}
