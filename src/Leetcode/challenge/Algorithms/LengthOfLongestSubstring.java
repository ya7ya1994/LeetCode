package Leetcode.challenge.Algorithms;


class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        String[] substring = new String[s.length()];
        int i = 0;
        int j = 0;
        String temp = "";
        if (s.length() == 1)
            return 1;
        while (i < s.length()) {
            if (temp.contains(String.valueOf(s.charAt(i)))) {
                substring[j] = temp;
                temp = "";
                if (i > 0 && s.charAt(i - 1) != s.charAt(i))
                {
                    //temp += s.charAt(i - 1);
                    int k =i-1;
                    while(s.charAt(k)!=s.charAt(i))
                    k--;
                    temp+=s.substring(k+1,i);
                }

                j++;
            }
            temp += s.charAt(i);
            if (i == s.length() - 1) {
                substring[j] = temp;
                j++;
            }

            i++;
        }
        return findMax(substring, j);
    }

    public int findMax(String[] str, int j) {
        int i = 0;
        int max = 0;
        while (i < j) {
            if (max < String.valueOf(str[i]).length()) {
                max = String.valueOf(str[i]).length();
            }
            i++;
        }
        return max;
    }
}