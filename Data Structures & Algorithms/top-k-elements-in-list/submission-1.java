class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer key : nums){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int itter = 0;

        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[itter++] = num;
                    if(itter == k) return res;
                }
            }
        }
        return res;

    }
}
