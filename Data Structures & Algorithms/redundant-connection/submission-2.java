class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] res = new int[2];
        for(int i = 1; i < edges.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int first = edges[i][0];
            int second = edges[i][1];

            int boss1 = find(first, parent);
            int boss2 = find(second, parent);


            if(boss1 != boss2){
               parent[boss2] = boss1;
            }
            else{
                res[0] = first;
                res[1] = second;
            }
        }
        return res;
    }
    private int find(int node, int[] parent){
        while(parent[node] != node){
            node = parent[node];
        }
        return node;
    }
}
