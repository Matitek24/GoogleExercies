class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int n : nums){
        set.add(n);
       }
    //    o n
        int max = 0;
        for(int i : set){
            
            if(!set.contains(i - 1)){
                int curnum = i;
                int count = 1;
                while(set.contains(curnum + 1)){
                    curnum = curnum + 1;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;

    }
}
