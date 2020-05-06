package Leetcode.challenge.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {


    public String convert(String s, int numRows) {
        List<String> rows = new ArrayList<>(numRows);
        int index = 0;
        int flag = 0;
        for (char c : s.toCharArray()) {
            String temp = "";
            if (index < rows.size()) {
                temp = rows.get(index);
                rows.set(index, temp + String.valueOf(c));
            } else
                rows.add(index,String.valueOf(c));
            if (index == numRows - 1 || flag == 1) {
                index--;
                if (index == 0)
                    flag = 0;
                else
                    flag = 1;
            } else {
                index++;
            }
        }
        index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < numRows) {
            sb.append(rows.get(index));
            index++;
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion myObj = new ZigZagConversion();
        System.out.println(myObj.convert("Multivitamin", 3));
    }

}
