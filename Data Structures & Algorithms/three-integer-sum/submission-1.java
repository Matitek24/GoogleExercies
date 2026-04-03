class Solution{
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i++){
			int left = i + 1;
			int right = nums.length - 1;
			int val1 = nums[i];

			if(i > 0 && val1 == nums[i - 1]) continue;

			while(left < right){
			int val2 = nums[left];
			int val3 = nums[right];
			
			if(val1 + val2 + val3 == 0){
            res.add(Arrays.asList(val1, val2 ,val3));
            left++;
            right--;
                while(left < right && nums[left] == nums[left - 1]) left++;
                while(left < right && nums[right] == nums[right + 1]) right--;
            }
            else if(val1 + val2 + val3 < 0){
                left++;
            }
            else{
                right--;
            }

            }
		}
		return res;
    }
}









