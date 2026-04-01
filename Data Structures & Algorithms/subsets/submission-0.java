class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(nums, res, new ArrayList<>(), 0);
        return res;
    }
    private void back(int[] nums, List<List<Integer>> res, List<Integer> currPath, int index){
        res.add(new ArrayList<>(currPath));

        for(int i = index; i < nums.length; i++){
            currPath.add(nums[i]);

            back(nums, res, currPath, i + 1);

            currPath.remove(currPath.size() - 1);
        }
    }
}
