class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int maxFr = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a ,0) + 1);
            maxFr = Math.max(maxFr, map.get(a));

            while((i - left + 1) - maxFr > k){
                char leftchar = s.charAt(left);
                map.put(leftchar, map.get(leftchar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
