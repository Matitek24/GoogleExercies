class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> que = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                 (a[0] * a[0] + a[1] * a[1])
            )
        );

        for(int[] point : points){
            que.offer(point);
           if(que.size() > k){
            que.poll();
           }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = que.poll();
        }
        return res;
    }
}
