lass MyStack {
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;
    boolean flag;

    public MyStack() {
        q1=new ArrayDeque<>();
        q2=new ArrayDeque<>();
        flag=true;        
    }
    
    public void push(int x) {
        if(flag){
            q1.add(x);
        }else{
            q2.add(x);
        }
    }
    
    public int pop() {
        int res=-1;
        if(flag){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            res=q1.poll();
        }else{
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            res=q2.poll();
        }
        flag=!flag;
        return res;
    }
    
    public int top() {
        int res=-1;
        if(flag){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            res=q1.poll();
            q2.add(res);
        }else{
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            res=q2.poll();
            q1.add(res);
        }
        flag=!flag;
        return res;
    }
    
    public boolean empty() {
        return q1.size()==0 && q2.size()==0;
    }
}
