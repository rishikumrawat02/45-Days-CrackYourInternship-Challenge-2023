class MyQueue {
    ArrayList st1 = new ArrayList();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.add(x);
    }
    
    public int pop() {
        return (int)st1.remove(0);
    }
    
    public int peek() {
        return (int)st1.get(0);
    }
    
    public boolean empty() {
        if(st1.isEmpty())
            return true;
        return false;
    }
}
