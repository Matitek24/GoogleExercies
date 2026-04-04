class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> (b - a));

        for(int stone : stones){
            max.offer(stone);
        }
        while(max.size() > 1){
            int first = max.poll();
            int second = max.poll();

            if(first < second){
                second = second - first;
                max.offer(second);
            }
            else{
                first = first - second;
                max.offer(first);
            }
        }
        return max.peek();
    }
}
