class Solution {
    public boolean canFinish(int numCourses, int[][] pre){
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] states = new int[numCourses];
    for(int i = 0; i < pre.length; i++){
        int key = pre[i][1];
        int value = pre[i][0];
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
            map.get(key).add(value);
    }

    for(int i = 0; i < numCourses; i++){
       if(dfs(i, states, map) == false){
        return false;
       }
    }
    return true;
    }
    private boolean dfs(int course, int[] states, Map<Integer, List<Integer>> map){
        if(states[course] == 1) return false;

        states[course] = 1;

        if(map.containsKey(course)){
            for(int k : map.get(course)){
                if(dfs(k, states, map) == false){
                    return false;
                }
            }
        }
        states[course] = 2;
        return true;
    }
}
