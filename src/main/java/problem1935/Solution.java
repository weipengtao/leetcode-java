package problem1935;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenSet = brokenLetters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        int count = 0;
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canType = false;
                    break;
                }
            }
            count += canType ? 1 : 0;
        }
        return count;
    }
}
