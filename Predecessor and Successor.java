


//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    TreeSet<Integer> set = new TreeSet<>();
    helper(root,set);
    Integer pred = set.lower(key); Integer succd = set.higher(key);
    if(pred!=null){
        pre=new Node(pred);
    }
    if(succd!=null){
        suc=new Node(succd);
    }
    return;
}

static void helper(Node root, TreeSet<Integer> set){
    if(root==null) return;
    set.add(root.data);
    helper(root.left,set);
    helper(root.right,set);
    return;
}
}
