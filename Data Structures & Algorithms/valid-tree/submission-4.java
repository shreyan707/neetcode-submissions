class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int e[] : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        int count=0;
        for(int c = 0; c<n; c++){

            if(!visiting.contains(c))
            {
                System.out.println("VISITING "+visiting);
                System.out.println("\n NEW NUM");
                count++;
                if(!dfs(c,-1)){
    
                return false;
                }
            }
        }
        
        if(count>1)
        {
            return false;
        }
    
        return true;
        
    }

    boolean dfs(int c, int parent){

        if(visiting.contains(c)){
            System.out.println("VISITED");
            return false;
        }

        visiting.add(c);
        System.out.println("\nEXPLORING:");
        System.out.println(c);
        for(int a : map.get(c)){

            if(parent==a) continue;            
            if(!dfs(a, c)){
                return false;
            }
        }

        return true;

    }
}
