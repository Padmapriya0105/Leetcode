import java.util.*;

class Solution {
    
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder currentPath, int index) {
      
        if (index == digits.length()) {
            result.add(currentPath.toString());
            return;
        }

       
        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            currentPath.append(c);             
            backtrack(result, digits, currentPath, index + 1);
            currentPath.deleteCharAt(currentPath.length() - 1); 
        }
    }
}
