class Solution {

    // X X Y Y 2 

    // 0 1 
    // X Y
    // 0 0
    // X Y 

    // X Y _ X Y      5 

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char task : tasks){
            counts[task - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int c : counts){
            if(c>0){
                maxHeap.offer(c);
            }
        }
        int time = 0;
        // fifo
        Queue<int[]> wait = new LinkedList<>();
        while(!wait.isEmpty() || !maxHeap.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int freq = maxHeap.poll();
                freq--;

                if(freq > 0){
                    wait.offer(new int[]{freq, time + n});
                }
            }

            if(!wait.isEmpty() && wait.peek()[1] == time){
                maxHeap.offer(wait.poll()[0]);
            }
        }
        return time;
    }
}
