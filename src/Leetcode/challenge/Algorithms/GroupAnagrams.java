package Leetcode.challenge.Algorithms;

import java.util.*;

class GroupAnagrams {
    public static String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0)
            return result;

        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }

        Map<String, Integer> inputSortMap = new HashMap<>();
        Map<Integer, List<String>> outputMap = new HashMap<>();
        int indexList = 0;

        for (String str : strs) {
            List<String> inputList = new ArrayList<>();
            String sortedString = sortString(str);

            if (!inputSortMap.containsKey(sortedString)) {
                inputSortMap.put(sortedString, indexList);
                indexList++;
            }

            if (outputMap.get(inputSortMap.get(sortedString)) != null)
                inputList = outputMap.get(inputSortMap.get(sortedString));

            inputList.add(str);
            outputMap.put(inputSortMap.get(sortedString), inputList);
        }
        indexList--;

        while (indexList >= 0) {
            result.add(outputMap.get(indexList));
            indexList--;
        }
        return result;
    }
}


