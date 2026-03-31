class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int[][] options = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    que.offer(new int[]{i,j});
                }
            }
        }
      
        while(!que.isEmpty()){
            int[] tab = que.poll();
            int x = tab[0];
            int y = tab[1];

            for(int[] o : options){
                int nextX = o[0] + x;
                int nextY = o[1] + y;

                if(nextX >= 0 && nextX < grid.length && 
                   nextY >= 0 && nextY < grid[0].length && 
                   grid[nextX][nextY] == 2147483647) {
                    
                    grid[nextX][nextY] = grid[x][y] + 1;
                    que.offer(new int[]{nextX, nextY});
                }
                
            }
        }
    }
}
