/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if(node==null) return node;
        if(node.neighbors.size()==0)
        {
            System.out.println("Error: The clone is the same object as the original.");
        }

        Set<Node> visited=new HashSet<>();
        HashMap<Node,Node> cache=new HashMap<>();

        cache.put(node, new Node(node.val));
        Node ans=cache.get(node);

        dfs(node,cache, visited);
        return ans;
        
    }

    public void dfs(Node node, HashMap<Node,Node> cache, Set<Node> visited)
    {
        if(visited.contains(node)) return;
        visited.add(node);

        if(!cache.containsKey(node))
        {
            cache.put(node, new Node(node.val));
        }


        Node cloneNode=cache.get(node);

        for(Node n: node.neighbors)
        {

            if(!cache.containsKey(n))
            {
                cache.put(n, new Node(n.val));
            }
            Node newNei=cache.get(n);
            
            cloneNode.neighbors.add(newNei);

            dfs(n,cache, visited);
        }
    }
}