class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for(String s : strs){
        char[] word = s.toCharArray();
        Arrays.sort(word);
        String key = new String(word);
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(s);
    }

    List<List<String>> res = new ArrayList<>();

    for(List<String> lis : map.values()){
        res.add(lis);
    }
    return res;
    }
    }

