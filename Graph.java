import java.util.*;
import java.lang.Math;

public class Graph {

    // Map<Node, Set<Node>> adjacencyLists;
    // Map<Integer, Node> nodes;

    // private int index;  // index used in Tarjan's algorithm
    // private Stack<Node> stack = new Stack<Node>();
    public List<List<Node>> SCCs = new ArrayList<List<Node>>();

    /** number of vertices **/
    private int V;
    /** preorder number counter **/
    private int preCount;
    /** low number of v **/
    private HashMap<Node,Integer> low;
    /** to check if v is visited **/
    private HashMap<Node,Boolean> visited;
    /** to store given graph **/
    private List<Node> nodes;
    /** to store all scc **/
    private List<List<Node>> SCCs;
    private Stack<Node> stack;

    Graph(List<Integer> vertices, List<List<Integer>> edges) {

        // create all nodes
        for(Integer id: vertices) {
            Node vertex = new Node();
            vertex.id = id;
            // this.adjacencyLists.put(vertex, new HashSet<Node>());
            nodes.put(id, vertex);

            V++;
        }
        // add all edges
        for(List<Integer> edge: edges) {
            Node from = nodes.get(edge.get(0));
            Node to = nodes.get(edge.get(1));

            from.children.add(to);
            to.parent.add(from);
        }
    }

    @Override
    public String toString() {
        return this.adjacencyLists.toString();
    }

    public List<List<Node>> tarjan()
    {
        V = nodes.length;
        //low = new int[V];
        //visited = new boolean[V];
        stack = new Stack<Node>();
        SCCs = new ArrayList<>();

        for (Node n: nodes)
            if (visited.get(v)==null || !visited.get(n))
                dfs(n);

        return SCCs;
    }

    /** function dfs **/
    public void dfs(Node v)
    {
        low.put(v,preCount++);
        visited.put(v,true);
        stack.push(v);
        int min = low.get(v);
        for (Node w : v.children)
        {
            if (!visited.get(w)||visited.get(w)==null)
                dfs(w);
            if (low.get(w) < min)
                min = low.get(w);
        }
        if (min < low.get(v))
        {
            low.get(v) = min;
            return;
        }
        List<Node> component = new ArrayList<Node>();
        Node w;
        do {
            w = stack.pop();
            component.add(w);
            low.get(w) = V;
        } while (w != v);
        SCCs.add(component);
    }

    public boolean satisfiable() {
        for(List<Node> i: SCCs) {
            for(int j=0;j<i.size();j++){
                for(int k=0;k<i.size();k++){
                    if(i.get(j)==-i.get(k)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Map<Integer, Boolean> solve() {
        Map<Integer, Boolean> solution = new HashMap<Integer, Boolean>();

        ArrayList<Node> leaves = new ArrayList<Node>;
        for (Node i:IG){
                if i.children.size!=0{
                    for (node i:children){
                        leaves.add(i);
                    }
                }
        }
        while leaves.size != 0{
            if(leaves[0].value==null){
                if(leaves[0].allChildrentrue()){
                    leaves[0].value=true;
                }
                else leaves[0].value=false;
                }

            for p:leaves[0].parents{
                if p.inLeaves(){
                    leaves.add(p)
                    leaves.remove(stack[0])
                }
            }
        }
        Map<String,Boolean> solution = newHashMap<>();
        for (Node i:nodes){
            solution.put(i.key(),i.value);
            System.out.println(i.key() + "=" + i.value.toString())
        }
            return solution;
        }

    }

