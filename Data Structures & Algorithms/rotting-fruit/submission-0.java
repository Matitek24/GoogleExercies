class Solution {

    public int orangesRotting(int[][] grid) {
    int counterFresh = 0;
    int minute = 0;
        Deque<int[]> que = new ArrayDeque<>();
        int[][] options = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1) counterFresh++;
                if(grid[r][c] == 2) que.add(new int[]{r,c});
            }
        }

        while(!que.isEmpty() && counterFresh > 0){
            int currWave = que.size();
            for(int i = 0; i < currWave; i++){
                 int[] currPosition = que.poll();

            int r = currPosition[0];
            int c = currPosition[1];

            for(int[] o : options){
                int nextR = r + o[0];
                int nextC = c + o[1];

                if(nextR >= 0 && nextC >= 0 &&
                    nextR < grid.length && nextC < grid[0].length && grid[nextR][nextC] == 1
                ){
                    grid[nextR][nextC] = 2;
                    que.add(new int[]{nextR, nextC});
                    counterFresh--;
                }
            }
            }
            minute++;
        }
        return counterFresh == 0 ? minute: -1;
    }
}
