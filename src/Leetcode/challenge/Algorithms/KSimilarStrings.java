class Solution {
    
    public int kSimilarity(String A, String B) {
        Map<String,Integer> memo = new HashMap<>();
        
        List<Integer> results = new ArrayList<>();
        
        findK(A,B,0,results,0,memo);
        
        int result = Integer.MAX_VALUE;
        for (Integer i : results) {
            //System.out.println(i + " ");
            result = Math.min(result,i);
        }
        
        return result ;
    }
    
    private void findK(String A, String B, int index, List<Integer> results, Integer count, Map<String,Integer> memo) {
        if (index >= B.length()) {
            results.add(count);
            return ;
        }
        
        if(memo.get(A) != null) {
            Integer value = memo.get(A);
            if(value > count) {
                memo.replace(A,count);
            }
            else {
                return ;
            }
        }
        
        
        char b = B.charAt(index);
        char a = A.charAt(index);
        
        while( index < B.length()-1 && a == b ) {
            index++;
            a = A.charAt(index);
            b = B.charAt(index);
        }
        if (b != a) {
            List<String> anagrams = new ArrayList<>(stringLoader(A,B,index));

            for (String str : anagrams) {
                memo.put(A,count);
                //System.out.println(memo.get(A) + " " + A);
                findK (str,B,index,results,count+1,memo);
            }
        }
        else {
            memo.put(A,count);
            results.add(count);
            return ;
        }
        
    }
        
    private String swap(String A, int i, int j) {
        char[] characters = A.toCharArray();
        char c = characters[i];
        characters[i] = characters[j];
        characters[j] = c;
        return String.valueOf(characters);
    }
    private List<String> stringLoader(String A, String B, int index) {
        char b = B.charAt(index);        
        List<String> anagrams = new ArrayList<>();
        for(int ia = index; ia < B.length(); ia++) {
            char a = A.charAt(ia);
            if(a == b) {
                anagrams.add(swap(A,ia,index));
            }
        }
        return anagrams;
    }
}
