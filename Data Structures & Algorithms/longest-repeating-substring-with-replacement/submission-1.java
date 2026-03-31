class Solution {
    public int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0; 
    int maxlen = 0;
    int maxFr = 0;

    for(int i = 0; i < s.length() ;i++){
        char currentChar = s.charAt(i);
        map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        maxFr = Math.max(maxFr ,map.get(currentChar));

        while((i - left + 1) - maxFr > k){
            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
            left++;
        }
        
        maxlen = Math.max(maxlen, i - left + 1);
    
    }
    return maxlen;

    }
}
