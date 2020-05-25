package Leetcode.challenge.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    static final char INVALID = '?';

    class Entry {
        Integer value;
        Character letter;

        public Entry(Integer v, Character c) {
            this.value = v;
            this.letter = c;
        }
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        char previous = INVALID;

        StringBuilder sb = new StringBuilder();
        while (sb.length() < S.length()) {
            char c = getMaxCountLetter(count, previous);
            if (c == INVALID) {
                return "";
            }

            sb.append(c);
            int countRemaining = count.get(c);
            if (countRemaining == 1) {
                count.remove(c);
            } else {
                count.put(c, countRemaining - 1);
            }
            previous = c;
        }
        return sb.toString();

    }

    public char getMaxCountLetter(Map<Character, Integer> count, char except) {
        Entry max = null;
        for (Character c : count.keySet()) {
            if (c == except)
                continue;
            if (max == null || max.value < count.get(c)) {
                max = new Entry(count.get(c), c);
            }
        }
        return max == null ? INVALID : max.letter;
    }

}
