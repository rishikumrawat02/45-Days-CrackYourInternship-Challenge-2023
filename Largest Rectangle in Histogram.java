class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            left[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        int right[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int res=0;
        for(int i=0; i<n; i++){
            int width=-left[i]+right[i]-1;
            res=Math.max(res,width*heights[i]);
        }
        return res;
    }
}
