class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int cnt=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            cnt+=st.pop()[1];
        }
        st.push(new int[]{price,cnt});
        return cnt;
    }
}
