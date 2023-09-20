class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            if(!set.add(n)) break;
            int digitSum=0;
            while(n!=0){
                digitSum+=((n%10)*(n%10));
                n/=10;
            }
            n=digitSum;
        }
        return n==1;
    }
}
