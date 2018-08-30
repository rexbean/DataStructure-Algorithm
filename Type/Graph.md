# Graph
| #   | # of Prob | Status    | Type             | note |
| --- | --------- | --------- | ---------------- | ---- |
| 1   | 207       | Completed | Topological sort |      |
| 2   | 210       | Completed | Topological sort |      |
| 3   | 310       | Completed | Onion                 |      |
## Node
``` Java
class Node{
    int index;                    // The index of the node
    List<Node> children;          // A list of children node
    public Node(int index, ArrayList<Node> children){
        this.index = index;
        this.children = children;
    }
}
```
## Edge
- There are two ways to represent edges. One is **Adjacency Matrix**, the other is **Adjacency List**.
### Adjacency Matrix
- It is a two dimensional array with '1's and '0's. '1' for an edge, '0' for disconnection.

  | \   | A   | B   | C   | D   | E   | F   |
  | --- | --- | --- | --- | --- | --- | --- |
  | A   | 0   | 1   | 1   | 1   | 0   | 0   |
  | B   | 1   | 0   | 0   | 0   | 1   | 1   |
  | C   | 1   | 0   | 0   | 0   | 0   | 1   |
  | D   | 1   | 0   | 0   | 0   | 0   | 0   |
  | E   | 0   | 1   | 0   | 0   | 0   | 0   |
  | F   | 0   | 1   | 1   | 0   | 0   | 0   |

- Advantages:
  - Easy to implemente by 2 dimension array
  - Easy to add / remove edges
- Drawbacks:
  - Waste of memory, when there is few edges.
  - Redundancy information, It has information of A to B but also has the information of B to A

### Adjacency List
- It is an array of linked list nodes.
  A -> B -> C -> D<br>
  B -> A -> E -> F<br>
  C -> A -> F<br>
  D -> A<br>
  E -> B<br>
  F -> B -> C<br>

## Build Graph
- Graph can be build from an array of Edges, Adjacency Matrix, Adjacency List to HashMap<Integer, HashSet<Integer>>
- Graph can be also built to ArrayList[];
### Build to a HashMap<Integer, HashSet<Integer>>
``` Java
public HashMap<Integer, HashSet<Integer>> buildGraph(int n){
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    if(edges == null || edges.length == 0 || edges[0].length == 0){
        return graph;
    }
    for(int i = 0; i < n; i++){
        graph.put(n, new HashSet<Integer>());
    }

    // Built from edges
    int[][] edges;
    for(int i = 0; i < edges.length; i++){
        int u = edges[i][0];
        int v = edges[i][1];

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Built from Adjacency Matrix
    int[][] adj;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(adj[i][j] == 1){
                graph.get(i).add(j);
            }
        }
    }

    // Built from Adjacency List
    LinkedList[] adj;
    for(int i = 0; i < n; i++){
        Iterator<Integer> temp = adj[i].listIterator();
        while(temp.hasNext()){
            int n = temp.next();
            graph.get(i).add(n);
        }
    }
    return graph;
}
```

### Build to ArrayList array
``` Java

public ArrayList[] buildGraph(int n){
    ArrayList[] graph = new ArrayList[n];
    if(edges == null || edges.length == 0 || edges[0].length == 0){
        return graph;
    }
    for(int i = 0; i < n; i++){
        graph[i] = new ArrayList<>();
    }

    // Built from edges
    int[][] edges;
    for(int i = 0; i < edges.length; i++){
        int u = edges[i][0];
        int v = edges[i][1];

        graph[u].add(v);
        graph[v].add(u);
    }

    // Built from Adjacency Matrix
    int[][] adj;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(adj[i][j] == 1){
                graph[i].add(j);
            }
        }
    }

    // Built from Adjacency List
    LinkedList[] adj;
    for(int i = 0; i < n; i++){
        Iterator<Integer> temp = adj[i].listIterator();
        while(temp.hasNext()){
            int n = temp.next();
            graph[i].add(n);
        }
    }
    return graph;
}
```
## Traversal
### BFS(Breadth-First Search)
#### Using Queue
```Java
HashMap<Integer, HashSet<Integer>> graph = buildGraph(n, edges);
/**
* A BFS function without recursion
**/
public void BFS(){
    boolean visited[] = new boolean[graph.size()];
    // call BFSHelper on each node
    for(Integer i: graph.keySet()){
        if(!visited[i]){
            BSFHelper(i, visited);
        }
    }
}


/**
* A BFS Helper
* index the index of the node
**/
private void BFSHelper(int index, boolean[] visited){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(index);
    visited[index] = true;
    while(!queue.isEmpty()){
        Integer v = queue.poll();
        System.out.print(v + " ");
        visited[index] = true;
        for(Integer neighbour: graph.get(v)){
            queue.offer(neighbour);
        }

        // when graph is an array of ArrayList
        for(Integer neighbour: graph[v])){
            queue.offer(neighbour);
        }
    }
}


```


### DFS(Depth First Search)

#### Using Recursion
``` Java
HashMap<Integer, HashSet<Integer>> graph = buildGraph(n, edges);
/**
* A DFS function
* n The number of Node in the graph
**/
void DFS(){
    boolean visited[] = new boolean[graph.size()];
    // call DFSHelper on each node
    for(Integer i : graph.keySet()){
       if(!visited[i]){
           DFSHelper(i, visited);
       }
    }
}

/**
* A DFS Helper
* index The index of the node
* visitied Whether a node has been visited or not
**/
void DFSHelper(int index, boolean[] visited){
    visited[index] = true;
    System.out.print(index+" ");

    // when graph is a HashMap with HashSet
    for(Integer neighbour : graph.get(i)){
        if(!visited[neighbour]){
            DFSHelper(neighbour, visited);
        }
    }

    // when graph is an Array of ArrayList
    for(Integer neighbour : graph[i]){
        if(!visited[neighbour]){
            DFSHelper(neighbour, visited);
        }
    }
}
```

#### Using Stack
``` Java
HashMap<Integer, HashSet<Integer>> graph = buildGraph(n, edges);
/**
* This ia a DFS function without recursion
*
**/
public void DFS() {
    boolean[] visited = new boolean[graph.size()];
    for(Integer i: graph.keySet()){
        if(!visited[i]){
            DFSHelper(i, visitied);
        }
    }
}


private void DFSHelper(Integer i, boolean[] visited){
    Deque<Integer> stack = new ArrayDeque<>();
    visited[i] = true;
    stack.push(i);
    while (!stack.isEmpty()) {
        int v = stack.peek();
        System.out.print(v + " ");
        for(Integer neighbour : graph.get(v)){
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                stack.push(neighbour);
            }
        }
        stack.pop();
    }

    // when graph isa an array of ArrayList
    while (!stack.isEmpty()) {
        int v = stack.peek();
        System.out.print(v + " ");
        for(Integer neighbour : graph[v]){
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                stack.push(neighbour);
            }
        }
        stack.pop();
    }
}
```

## Topological Sort
- It's better to use BFS to do the topological sort
``` Java
// Compute the in-degree of all nodes
int[] inDegree = new int[graph.size()];
for(Integer i: graph.keySet()){
    inDegree[i]++;
}


// Find the node whose in-degree is 0
Queue<Integer> queue = new LinkedList<>();
for(int i = 0; i < inDegree.length; i++){
    if(inDegree[i] == 0){
        queue.offer(i);
    }
}

// Use BFS to traverse nodes to do the topological sort
while(!queue.isEmpty()){
    Integer v = queue.poll();
    System.out.println(v + "->");
    for(Integer neighbour: graph.get(v)){
        inDegree[neighbour]--;
        if(inDegree[neighbour] == 0){
            queue.offer(neighbour);
        }
    }
}
```

## UnionFind

## Find a Ring

## Find the smallest Ring
