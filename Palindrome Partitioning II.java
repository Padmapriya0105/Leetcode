class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int n = s.length();
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        for (int center = 0; center < n; center++) {
            expandAroundCenter(s, center, center, cuts);
            expandAroundCenter(s, center, center + 1, cuts);
        }
        
        return cuts[n - 1];
    } 
    private void expandAroundCenter(String s, int left, int right, int[] cuts) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                cuts[right] = 0;
            } else {
                cuts[right] = Math.min(cuts[right], cuts[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}
