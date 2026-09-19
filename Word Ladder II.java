import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord,
                                           String endWord,
                                           List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not present, no solution exists
        if (!wordSet.contains(endWord)) {
            return result;
        }

        // parent map: word -> previous words in shortest paths
        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            // Remove words visited in the previous level
            wordSet.removeAll(currentLevel);

            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord)) {

                            nextLevel.add(nextWord);

                            parents
                                .computeIfAbsent(nextWord,
                                    k -> new ArrayList<>())
                                .add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        // Build all shortest paths using DFS
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            buildPaths(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void buildPaths(String current,
                            String beginWord,
                            Map<String, List<String>> parents,
                            List<String> path,
                            List<List<String>> result) {

        if (current.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        if (!parents.containsKey(current)) {
            return;
        }

        for (String parent : parents.get(current)) {

            path.add(parent);

            buildPaths(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}
