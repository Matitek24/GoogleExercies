class Solution {
    Deque<Integer> que = new ArrayDeque<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(dfs(i, map, state) == false) return new int[0];
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!que.isEmpty()){
            res[index++] = que.poll();
        }
        return res;
    }
    private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] state){
        if(state[course] == 1) return false;
        if(state[course] == 2) return true;

        state[course] = 1;

        if(map.containsKey(course)){
            for(int k : map.get(course)){
                if(dfs(k,map,state) == false){
                    return false;
                }
            }
        }

        state[course] = 2;
        que.push(course);
        return true;
    }
}
