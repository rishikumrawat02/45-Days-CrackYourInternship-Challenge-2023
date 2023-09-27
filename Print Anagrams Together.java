
class Solution {
    class Trie{
        List<String> res=new ArrayList<>();
        Trie arr[] = new Trie[26];
    }
    Trie root = new Trie();
    
    void insert(String word){
        char arr[] = word.toCharArray();
        Arrays.sort(arr);
        Trie curr = root;
        for(int i=0; i<arr.length; i++){
            if(curr.arr[arr[i]-'a']==null){
                curr.arr[arr[i]-'a']=new Trie();
            }
            curr=curr.arr[arr[i]-'a'];
        }
        curr.res.add(word);
    }
    
    void helper(Trie cur, List<List<String>> ans){
        if(cur==null) return;
        if(cur.res.size()!=0){
            ans.add(cur.res);
        }
        for(int i=0; i<26; i++){
            helper(cur.arr[i],ans);
        }
        return;
    }
    
    
    public List<List<String>> Anagrams(String[] list) {
        for(int i=0; i<list.length; i++){
            insert(list[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        helper(root,ans);
        
        Collections.sort(ans,new Comparator<List<String>>(){
            public int compare(List<String> list1, List<String> list2){
                int minSize = Math.min(list1.size(), list2.size());
                for (int i = 0; i < minSize; i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp; 
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            }
        });
        
        return ans;
    }
}
