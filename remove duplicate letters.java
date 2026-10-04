import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]--;

            if (used[index]) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > c
                    && count[stack.peek() - 'a'] > 0) {

                used[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            used[index] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
