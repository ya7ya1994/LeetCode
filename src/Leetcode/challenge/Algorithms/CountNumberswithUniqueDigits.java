package Leetcode.challenge.Algorithms;

public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int result = 9, digits = 9;

        for (int i = 1; i < n; i++) {
            result *= digits;
            digits--;
        }
        return result + countNumbersWithUniqueDigits(n - 1);
    }

}
