import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;

        // Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        // Search from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root);
            }
        }

        return result;
    }

    private void dfs(int row, int col, TrieNode node) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        if (c == '#') {
            return;
        }

        TrieNode next = node.children[c - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = '#';

        dfs(row + 1, col, next);
        dfs(row - 1, col, next);
        dfs(row, col + 1, next);
        dfs(row, col - 1, next);

        board[row][col] = c;
    }
}

