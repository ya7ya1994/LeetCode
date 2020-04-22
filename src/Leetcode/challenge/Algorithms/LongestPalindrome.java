package Leetcode.challenge.Algorithms;

class LongestPalindrome {
    public LongestPalindrome() {
    }

    public String longestPalindrome(String s) {

        if (s.isEmpty())
            return "";
        int left = 0, right = s.length() - 1;
        String result = String.valueOf(s.charAt(0));
        int memoryRight = right;
        int memoryLeft = left;
        while (right > left) {
            memoryLeft = left;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (isPalindrome(s.substring(left, right + 1))) {
                        if (result.length() <= right - left + 1) {
                            result = s.substring(left, right + 1);
                        }
                        break;
                    }
                }
                left++;

            }
            left = memoryLeft;
            memoryRight = right;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (isPalindrome(s.substring(left, right + 1))) {
                        if (result.length() <= right - left + 1) {
                            result = s.substring(left, right + 1);
                        }
                        break;
                    }
                }
                right--;

            }
            right = memoryRight;
            left++;
            right--;
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (right > left) {
            if (s.charAt(left) != s.charAt(right))
                break;
            right--;
            left++;
        }

        return (left >= right);
    }
}