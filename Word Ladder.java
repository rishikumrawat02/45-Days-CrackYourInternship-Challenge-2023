class Solution {
    class Pair{
        String word; int step;
        Pair(String word,int step){this.word=word; this.step=step;};
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord,1)); int len=beginWord.length();
        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.word.equals(endWord)) return cur.step;
            char arr[] = cur.word.toCharArray();
            for(int i=0; i<len; i++){
                char prev=arr[i];
                for(char ch='a'; ch<='z'; ch++){
                    arr[i]=ch;
                    if(set.contains(new String(arr))){
                        set.remove(new String(arr));
                        q.add(new Pair(new String(arr),cur.step+1));
                    }
                }
                arr[i]=prev;
            }
        }
        return 0;
    }
}
