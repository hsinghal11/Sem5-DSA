class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        char[] brokenWords = brokenLetters.toCharArray();
        boolean[] charExists = new boolean[26];
        for (char c : brokenWords) {
            charExists[c - 'a'] = true;
        }
        int count = 0;
        for (String word : arr) {
            if (!hasBrokenLetters(word, charExists)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBrokenLetters(String s, boolean[] charExists) {
        for (int i = 0; i < s.length(); i++) {
            if (charExists[s.charAt(i) - 'a']) {
                return true;
            }
        }
        return false;
    }
}