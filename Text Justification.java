class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[] prefSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + words[i].length();
        }
        
        List<String> res = new ArrayList<>();
        int idx = 0;
        while (idx < n) {
            int nextIdx = find(prefSum, idx + 1, maxWidth);
            if (nextIdx == n) {
                StringBuilder str = new StringBuilder();
                for (int i = idx; i < n; i++) {
                    str.append(words[i]);
                    if (i != n - 1) str.append(" ");
                }
                while (str.length() < maxWidth) str.append(" ");
                res.add(str.toString());
            } else {
                int spacesRemaining = maxWidth - (prefSum[nextIdx] - prefSum[idx]);
                int wordCount = nextIdx - idx;
                if (wordCount == 1) {
                    StringBuilder str = new StringBuilder();
                    str.append(words[idx]);
                    while (str.length() < maxWidth) str.append(" ");
                    res.add(str.toString());
                } else {
                    int equalSpaces = spacesRemaining / (wordCount - 1);
                    int extraSpaces = spacesRemaining % (wordCount - 1);
                    StringBuilder str = new StringBuilder();
                    for (int i = idx; i < nextIdx; i++) {
                        str.append(words[i]);
                        if (i != nextIdx - 1) {
                            for (int j = 0; j < equalSpaces; j++) str.append(" ");
                            if (extraSpaces > 0) {
                                str.append(" ");
                                extraSpaces--;
                            }
                        }
                    }
                    res.add(str.toString());
                }
            }
            idx = nextIdx;
        }
        return res;
    }

    int find(int[] prefSum, int idx, int max) {
        int low = idx;
        int high = prefSum.length - 1;
        int res = idx;
        while (low <= high) {
            int mid = (low + high) / 2;
            int len = prefSum[mid] - prefSum[idx - 1] + (mid - idx);
            if (len <= max) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
