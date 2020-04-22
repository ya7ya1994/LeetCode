package Leetcode.challenge.Algorithms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class PopularNFeatures {
    public PopularNFeatures() {
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {

        ArrayList<String> finalList = new ArrayList<>();
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (count < numFeatures) {
            String temp = "";
            temp = possibleFeatures.get(count);
            for (String i : featureRequests) {
                if (i.toLowerCase().contains(temp.toLowerCase())) {
                    //Map each possibleFeature with its frequency
                    if (map.get(count) != null)
                        map.put(count, map.get(count) + 1);
                    else
                        map.put(count, 1);
                }

            }
            count++;
        }
        count = topFeatures;
        while (count > 0) {
            int max = 0;
            int max_index = 0;
            for (int i : map.keySet()) {
                if (max < map.get(i)) {
                    max = map.get(i);
                    max_index = i;
                }

            }
            finalList.add(possibleFeatures.get(max_index));
            map.remove(max_index);
            count--;
        }

        return finalList;
    }
    // METHOD SIGNATURE ENDS


    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int[] tableInt = new int[logFileSize];
        int countInt = 0;
        int countString = 0;
        String[] tableString = new String[logFileSize];
        while (count < logFileSize) {
            String temp = logLines.get(count);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {

                    if (Character.isLetter(temp.charAt(i + 1))) {
                        tableString[countString] = temp;
                        countString++;
                    }
                    if (Character.isDigit(temp.charAt(i + 1))) {
                        tableInt[countInt] = count;
                        countInt++;
                    }
                    break;
                }
            }
            count++;
        }
        Arrays.sort(tableString);
        for (int i=0;i<tableString.length;i++)
            list.add(tableString[i]);
        for (int i=0;i<tableInt.length;i++)
            list.add(logLines.get(tableInt[i]));

        return list;
    }
}
//The result is positive if the first string is lexicographically greater than the second string else the result would be negative.