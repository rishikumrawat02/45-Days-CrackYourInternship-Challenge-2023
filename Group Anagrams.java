class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr); String cur = new String(arr);
            map.putIfAbsent(cur,new ArrayList<>());
            map.get(cur).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
