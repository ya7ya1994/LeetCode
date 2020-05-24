package Leetcode.challenge.Algorithms;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFb {
public static void main(String[] args)
{
    char[] alphabet = {'c','a','b','t'};
    String[] words = {"ca","cat","bat","tab"};
    DictionaryFb di = new DictionaryFb();
    System.out.println(di.isSorted(words,alphabet));
    }

    boolean isSorted(String[] words, char[] alphabet) {
        Map<Character, Integer> alpha = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            alpha.put(alphabet[i], i);
        }
        for (int i = 0; i < words.length - 1; i++)
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (alpha.get(words[i].charAt(j)) > alpha.get(words[i + 1].charAt(j))) {
                    return false;
                } else if (alpha.get(words[i].charAt(j)) < alpha.get(words[i + 1].charAt(j))) {
                    break;
                }
                else
                {
                    if (words[i+1].length()-1 == j && words[i].length()-1 > j)
                    {
                        return false;
                    }
                    continue;
                }
            }
            return true;
    }
}
