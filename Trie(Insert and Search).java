static void insert(TrieNode root, String key) 
{
    for(int i=0; i<key.length(); i++){
        char c=key.charAt(i);
        if(root.children[c-'a']==null){
            root.children[c-'a']=new TrieNode();
        }
        root=root.children[c-'a'];
    }
    root.isEndOfWord=true;
    return;
    
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    
   for(int i=0; i<key.length(); i++){
       char c=key.charAt(i);
       if(root.children[c-'a']==null) return false;
       root=root.children[c-'a'];
   }
   return root.isEndOfWord;
}
