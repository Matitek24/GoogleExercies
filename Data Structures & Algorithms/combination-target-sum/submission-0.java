class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        back(0, nums, target, new ArrayList<>(), res);
        return res;
    }
    private void back(int start, int[] nums, int currtarget, List<Integer> path, List<List<Integer>> res){
        if(currtarget < 0 ) return;

        if(currtarget == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++){

            path.add(nums[i]);

            back(i, nums, currtarget - nums[i], path, res);

            path.remove(path.size() - 1);
        }
    }
}
