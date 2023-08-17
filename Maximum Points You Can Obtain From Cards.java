class Solution {
    public int maxScore(int[] card, int k) {
        int n=card.length; int sublen=n-k;
        for(int i=1; i<n; i++){
            card[i]+=card[i-1];
        }
        if(sublen==0) return card[n-1];

        int minSum=Integer.MAX_VALUE;
        for(int i=0; i<=n-sublen; i++){
            int sum=card[i+sublen-1];
            if(i-1>=0) sum-=card[i-1];
            minSum=Math.min(minSum,sum);
        }
        return card[n-1]-minSum;
    }
}
