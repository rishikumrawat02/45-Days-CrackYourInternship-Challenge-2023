class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int lSmall[] = new int[n];
        int rSmall[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            lSmall[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            rSmall[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        long res=0; int mod=(int)1e9+7;
        for(int i=0; i<n; i++){
            int leftElem=i-lSmall[i];
            int rigtElem=rSmall[i]-i;
            res+=((leftElem*1l)*rigtElem*arr[i]);
            res%=mod;
        }
        return (int)res;
    }
}
