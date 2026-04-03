class Solution {
    public int[] dailyTemperatures(int[] temp){
        // LIFO que
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[temp.length];

        for(int i = 0; i < temp.length; i++){
            while(!queue.isEmpty() && temp[queue.peek()] < temp[i]){
                int index = queue.pop();
                res[index] = i - index;
            }
            queue.push(i);
        }
        return res;
    }
}
