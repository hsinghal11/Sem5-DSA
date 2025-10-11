class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return ans;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int n = s.length();

        // store required word counts
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // just like your sliding window idea — loop through offsets
        for (int i = 0; i < wordLen; i++) {
            int si = i;
            int ei = i;
            Map<String, Integer> window = new HashMap<>();
            int count = 0;

            while (ei + wordLen <= n) {
                String w = s.substring(ei, ei + wordLen);
                ei += wordLen;

                if (freq.containsKey(w)) {
                    window.put(w, window.getOrDefault(w, 0) + 1);
                    count++;

                    // too many of the same word → shrink
                    while (window.get(w) > freq.get(w)) {
                        String leftWord = s.substring(si, si + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        si += wordLen;
                        count--;
                    }

                    // valid window found
                    if (count == words.length) {
                        ans.add(si);

                        // move left by one word to continue checking
                        String leftWord = s.substring(si, si + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        si += wordLen;
                        count--;
                    }
                } else {
                    // reset if word not found
                    window.clear();
                    count = 0;
                    si = ei;
                }
            }
        }

        return ans;
    }
}