class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int parts, String current,
                           List<String> result) {

        if (parts == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            if (segment.length() > 1 && segment.charAt(0) == '0') {
                break;
            }

            int value = Integer.parseInt(segment);

            if (value <= 255) {
                backtrack(s, index + len, parts + 1,
                          current + segment + ".", result);
            }
        }
    }
}
