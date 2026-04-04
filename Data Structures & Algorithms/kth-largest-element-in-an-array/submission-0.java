class Solution {
    public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> min_heap = new PriorityQueue<>();
            for(int num : nums){
                min_heap.offer(num);
                if(min_heap.size() > k){
                    min_heap.poll();
                }
            }
            return min_heap.peek();
    }
}
