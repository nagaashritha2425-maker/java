import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        String result = "";

        Set<String> set = new HashSet<>();
        set.add("");

        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);

            if (set.contains(prefix)) {
                if (word.length() > result.length()) {
                    result = word;
                }

                set.add(word);
            }
        }

        return result;
    }
}
