class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        back(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    private void back(int start, int[] candidates, int curtarget,  List<List<Integer>> res , List<Integer> path){
        if(curtarget < 0 ) return;
        if(curtarget == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;

            path.add(candidates[i]);

            back(i + 1, candidates, curtarget - candidates[i], res, path);

            path.remove(path.size() - 1);
        }
    }
}
