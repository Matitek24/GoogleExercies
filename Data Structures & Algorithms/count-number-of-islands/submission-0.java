class Solution {
     int count = 0;
    public int numIslands(char[][] grid) {
           
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int x, int y){
           
           if(x < 0 || x >= grid.length || y >= grid[0].length || y < 0 || grid[x][y] == '0'){
            return;
           }
           grid[x][y] = '0';

           dfs(grid, x + 1,y);
           dfs(grid, x - 1, y);
           dfs(grid, x, y + 1);
           dfs(grid, x, y - 1);
    }
}
