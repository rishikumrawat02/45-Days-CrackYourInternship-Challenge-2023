


class twoStacks
{
    //Function to push an integer into the stack1.
    int maxsize=(int)1e4+2;
    int arr[] = new int[maxsize];
    int top1=-1; int top2=maxsize;
    void push1(int x)
    {
        arr[++top1]=x;
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
       arr[--top2]=x;
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1==-1) return -1;
        return arr[top1--];
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2==maxsize) return -1;
        return arr[top2++];
    }
}
