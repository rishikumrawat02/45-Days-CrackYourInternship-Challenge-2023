class GfG 
{
    public static Node rearrange(Node head)
    {
        ArrayList<Node> arr = new ArrayList<>();
        ArrayList<Node> a = new ArrayList<>();
        
        Node temp = head;
        while(temp!=null){
            arr.add(temp);
            temp = temp.next;
        }
        
        int start = 0;
        int end = arr.size()-1;
        
        while(start<=end){
            a.add(arr.get(start));
            a.add(arr.get(end));
            start++;
            end--;
        }
        
        for(int i=0; i<a.size()-2; i++){
            a.get(i).next = a.get(i+1);
        }
        
        a.get(a.size()-1).next = null;
        
        return a.get(0);
        
    }
}
