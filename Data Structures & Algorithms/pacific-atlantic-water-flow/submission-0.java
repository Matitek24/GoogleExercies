class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] reachPacific = new int[heights.length][heights[0].length];
        int[][] reachAtlantic = new int[heights.length][heights[0].length];
      
        Deque<int[]> Pqueue = new ArrayDeque<>();
        Deque<int[]> Aqueue = new ArrayDeque<>();

        for(int r = 0; r < heights.length; r++){
            for(int c = 0; c < heights[r].length; c++){
                if(r == 0 || c == 0){
                    reachPacific[r][c] = 1;
                    Pqueue.add(new int[]{r,c});
                }
                if(r == heights.length - 1 || c == heights[0].length - 1){
                    
                    reachAtlantic[r][c] = 1;
                    Aqueue.add(new int[]{r,c});
                }
            }
        }

        bfs(heights, Pqueue, reachPacific);
        bfs(heights, Aqueue, reachAtlantic);

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < heights.length; r++){
            for(int c = 0; c < heights[r].length; c++){
                if(reachAtlantic[r][c] == 1 && reachPacific[r][c] == 1){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Deque<int[]> queue, int[][] map){
          int[][] options = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            for(int[] o : options){
                int nextR = r + o[0];
                int nextC = c + o[1];
           
                if(nextR >= 0 && nextC >= 0 && nextR < heights.length && nextC < heights[0].length && map[nextR][nextC] != 1 && heights[nextR][nextC] >= heights[r][c]){
                    queue.add(new int[]{nextR, nextC});
                    map[nextR][nextC] = 1;
                }
            }
        }
    }
}
