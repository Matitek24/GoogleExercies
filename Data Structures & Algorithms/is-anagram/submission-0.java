class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int j = 0; j < t.length(); j++){
            char a = t.charAt(j);

            if(!map.containsKey(a) || map.get(a) == 0){
                return false;
            }
            map.put(a, map.getOrDefault(a,0) - 1);
        }
        return true;
    }
}
