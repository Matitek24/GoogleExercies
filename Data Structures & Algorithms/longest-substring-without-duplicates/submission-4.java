class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            while(set.contains(currentChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);

            max = Math.max(max, set.size());
        }
        return max;
    }
}
