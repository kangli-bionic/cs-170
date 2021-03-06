
http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
https://www.youtube.com/watch?v=joqmqvHC_Bo

class Main{
    public static void main(String[] args){
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
 
        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");    

        Graph g3 = new Graph(5);
        g3.addEdge(0, 4);
        g3.addEdge(0, 1);
        g3.addEdge(3, 0);
        g3.addEdge(2, 0);
        //g3.DFS();
        
        if (g3.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle"); 
    }
}

class Graph{
    private int V;
    private int flag = 0;
    private LinkedList<Integer> adjacencyList[];
    public Graph(int size){
        this.V = size + 1;
        adjacencyList = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adjacencyList[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

    public boolean isCyclic(){
        DFS();
        return flag == 1;
    }

    public void DFS(){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++){
            System.out.println(i + ":");
            if(!visited[i])
                dfsHelper(visited, i, st);
        }
    }

    public void dfsHelper(boolean[] visited, int i, Stack<Integer> st){
        st.push(i);
        visited[i] = true;
        for (int k: adjacencyList[i]){
            if (!visited[k])
                dfsHelper(visited, k, st);
            else if (st.contains(k))
                flag = 1;
        }
        if (flag != 1)
            st.pop();
    }
}