class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map <String, List<String>> map = new HashMap<>();
    for(String w : strs){
        char[] charTable = w.toCharArray();
        Arrays.sort(charTable);
        String key = new String(charTable);

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(w);
    }
    return new ArrayList<>(map.values());
    }
}
