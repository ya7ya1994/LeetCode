class Solution {
    public int maxVowels(String s, int k) {
        int result = 0;
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        String sub = s.substring(0,k);
        for(char c : sub.toCharArray()) {
            if(vowels.contains(c)) {
                result++;
            }
        }
    
        int prevVowelsCount = result;
        
        for(int i = 1; i + k <= s.length() ; i++) {
            char cprev = s.charAt(i-1);
            char cnext = s.charAt(i-1+k);
            
            int vowelsCount = prevVowelsCount;
            
            if(vowels.contains(cprev)) {
                vowelsCount--;
            }
            if(vowels.contains(cnext)) {
                vowelsCount++;
            }
            
            prevVowelsCount = vowelsCount;
            result = Math.max(result,vowelsCount);
        }
        
        return result;
    }
}
