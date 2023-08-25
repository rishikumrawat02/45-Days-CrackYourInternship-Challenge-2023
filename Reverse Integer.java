class Solution {
    public int reverse(int x) {
        long rev=0l;
        while(x!=0){
            int dig=x%10;
            x/=10;
            rev=rev*10+dig;
        }
        if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}
