public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        st=new Stack<>();
        addList(nestedList);
    }

    @Override
    public Integer next() {
        if(hasNext()==false) return null;
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty() && !st.peek().isInteger()){
            addList(st.pop().getList());
        }
        return !st.isEmpty();
    }

    void addList(List<NestedInteger> list){
        for(int i=list.size()-1; i>=0; i--){
            st.push(list.get(i));
        }
    }
}
