class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> temp = new HashSet<Integer>();
        for (Integer n : nums){
            temp.add(n);
        }
        return nums.length > temp.size();
    }
}