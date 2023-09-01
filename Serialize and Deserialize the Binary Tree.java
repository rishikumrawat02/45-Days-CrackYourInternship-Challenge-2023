public class Codec {

    int nullVal=Integer.MIN_VALUE;
    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        encode(root,string);
        return string.toString().trim();
    }

    void encode(TreeNode root, StringBuilder string){
        if(root==null){
            string.append(nullVal);
            string.append(" ");
            return;
        }
        string.append(root.val);
        string.append(" ");
        encode(root.left,string);
        encode(root.right,string);
        return;
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) {
        String arr[] = data.split(" ");
        return decode(arr);
    }

    TreeNode decode(String arr[]){
        if(idx==arr.length) return null;
        int val = Integer.parseInt(arr[idx++]);
        if(val==nullVal) return null;
        TreeNode root = new TreeNode(val);
        root.left=decode(arr);
        root.right=decode(arr);
        return root;
    }


}
