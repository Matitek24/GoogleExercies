class Solution{
    public int lengthOfLongestSubstring(String s){
    Set<Character> set = new HashSet<>();
    int res = 0;
    int left = 0;
    for(int i = 0; i < s.length(); i++){
        while(set.contains(s.charAt(i))){
        set.remove(s.charAt(left));
        left++;
    }
        set.add(s.charAt(i));
        res = Math.max(res, set.size());
    }
    return res;
    }
}
