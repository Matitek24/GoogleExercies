class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisities){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < prerequisities.length; i++){
            map.putIfAbsent(prerequisities[i][1], new ArrayList<>());
            map.get(prerequisities[i][1]).add(prerequisities[i][0]);
        }
        
        int[] states = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(dfs(states, map, i) == false){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] states,  Map<Integer,List<Integer>> map, int lesson){
        if(states[lesson] == 1) return false;
        if(states[lesson] == 2) return true;

        states[lesson] = 1;

        if(map.containsKey(lesson)){
            for(int n : map.get(lesson)){
                if(dfs(states, map, n) == false){
                    return false;
                }
            }
        }
        states[lesson] = 2;
        return true;
    }
     
}
