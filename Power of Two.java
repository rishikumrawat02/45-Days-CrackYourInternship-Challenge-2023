class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        int bitCnt=Integer.bitCount(n);
        return bitCnt==1;
    }
}
