class MagicDictionary {
    private TreeMap <String,String[]> words;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new TreeMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            String[] wordVariants = getVariants(word);
            words.put(word,wordVariants);
        }
    }
    
    private String[] getVariants(String s) {
        String[] results = new String[s.length()];
        StringBuilder variant = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            variant.setCharAt(i,'.');
            results[i] = variant.toString();
            variant.setCharAt(i,s.charAt(i)); 
        }
        
        return results;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String key : words.keySet()) {
            if (!key.equals(word) && key.length() == word.length()) {
                int index = 0;
                String[] wordVariants = getVariants(word);
                String[] keyVariants = words.get(key);
                while (index < wordVariants.length) {
                    if (wordVariants[index].equals(keyVariants[index])) {
                        return true;
                    }
                    index++;
                }
            }
        }
        
        
        return false;
    }
}
