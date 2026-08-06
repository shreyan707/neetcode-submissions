class Solution {
    private List<List<Integer>> adj = new LinkedList<>();
    
    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }


        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i, visited);
            }
        }

        return count;
    }

    private void dfs(int c, boolean[] visited){
        
        visited[c] = true;

        for(int i : adj.get(c)){
            if(!visited[i]){
                dfs(i, visited);
            }
        }

        return;


    }
}
