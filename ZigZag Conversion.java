import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        // Base case: if rows are 1 or string is shorter than rows, no zigzag happens
        if (numRows == 1 || s.length() <= numRows) return s;

        // Use a list of StringBuilders to represent each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            
            // If we are at the top or bottom row, reverse the direction
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down
            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
