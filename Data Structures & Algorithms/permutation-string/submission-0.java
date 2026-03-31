class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int size = s1.length();
        for(int i = 0; i < size; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s2.length() - size; i++){
            if(map2.equals(map)){
                return true;
            }
            char start = s2.charAt(i);
            char end = s2.charAt(size + i);

            if(map2.get(start) == 1){
                map2.remove(start);
            }else{
                map2.put(start, map2.get(start) - 1);
            }
            map2.put(end, map2.getOrDefault(end, 0) + 1);


        }

        return map2.equals(map);
    }
}
