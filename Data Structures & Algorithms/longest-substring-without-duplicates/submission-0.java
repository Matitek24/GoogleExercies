class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
        
            while(set.contains(a)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(a);

            max = Math.max(max, set.size());
        }
        return max;
    }
}
