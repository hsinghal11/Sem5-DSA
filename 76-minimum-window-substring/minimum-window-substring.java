import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return "";

        int[] point = new int[1]; // to store start index of valid window
        String ans = "";
        int low = m, high = n;
        int minLength = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(s, t, point, mid)) {
                // store current best
                if (mid < minLength) {
                    minLength = mid;
                    ans = s.substring(point[0], point[0] + mid);
                }
                high = mid - 1; // try smaller window
            } else {
                low = mid + 1; // need bigger window
            }
        }
        return ans;
    }

    public boolean isValid(String s, String t, int[] point, int mid) {
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int[] freq2 = new int[256];
        // First window of size mid
        for (int i = 0; i < mid; i++) {
            freq2[s.charAt(i)]++;
        }
        if (covers(freq2, freq)) {
            point[0] = 0;
            return true;
        }

        // Slide the window
        for (int i = mid; i < s.length(); i++) {
            freq2[s.charAt(i)]++;           // add new char
            freq2[s.charAt(i - mid)]--;     // remove old char
            if (covers(freq2, freq)) {
                point[0] = i - mid + 1;
                return true;
            }
        }
        return false;
    }

    // helper to check if freq2 covers all required chars in freq
    private boolean covers(int[] freq2, int[] freq) {
        for (int j = 0; j < 256; j++) {
            if (freq2[j] < freq[j]) return false;
        }
        return true;
    }
}
