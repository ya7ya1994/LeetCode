class Solution {
    public int numDecodings(String s) {
      if (s.length() == 0 || (s.length() == 1 && Integer.valueOf(s) == 0)) {
          return 0;
      }
        
        
        //int size = s.length();
        int[] subPrb = new int[s.length()+1];
        
        subPrb[0] = 1;
        subPrb[1] = s.charAt(0) == '0' ? 0 : 1;
        
        
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            
            if (first >=1 && first <= 9) {
                subPrb[i] += subPrb[i-1];
            }
            if (second >=10 && second <= 26) {
                subPrb[i] += subPrb[i-2];
            }
        }
        
        return subPrb[s.length()];
    }
    
    
}
