class Solution {
    public java.util.List<String> fullJustify(String[] words, int maxWidth) {
        java.util.List<String> res = new java.util.ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = j - i - 1;

            if (j == words.length || diff == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                int spaces = (maxWidth - lineLength) / diff;
                int extra = (maxWidth - lineLength) % diff;
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s <= (spaces + (k - i < extra ? 1 : 0)); s++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}
