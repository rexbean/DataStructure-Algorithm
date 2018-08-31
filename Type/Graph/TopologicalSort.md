# Topological Sort -- onion peeling
- [Procedure](#procedure)
- [Tips](#tips)
- [Applications](#applications)
  - Judge whether a graph has a ring
  - Built a graph from pairs of orders
    - Find length of the longest path
    - Find the minimum height tree
- [Implementation](#implementation)

| #   | # of Prob | Status    | Type             | note |
| --- | --------- | --------- | ---------------- | ---- |
| 1   | 207       | Completed | Topological Sort | whether things can be done<br>according to the order     |
| 2   | 210       | Completed | Topological Sort | output the order     |
| 3   | 444       | To be Done | Topological Sort | 1. How many ways can get the end<br> 2. judge whether a graph's nodes are in the order of other sequence     |
## <h2 id = "procedure">Procedure</h2>
- Built the graph from pairs of order
  - Using pairs to build a graph(ArrayList[]/ Array[][])
  - Compute the inDegree
  - Do something with the leaf
  - Update the inDegree, find the new leaves.
- Compute the in Degree
- Do BFS and update the in Degree
## <h2 id = "tips">Tips</h2>
- Using Adjacency Matrix and for-loop can add the element into the queue in a specific order
- The number of the elements in the queue represents how many ways it can go next
## <h2 id = "applications">Applications</h2>
- **Judge whether a graph has a ring**
  - When inDegree is 0, count++; Offer it into the Queue
  - When Queue is Empty, compare the count and number of node.
  - If count == # of node, it does not have ring.
  - Otherwise, it has a ring
- **Find the longest path in the graph**
  - When doing the BFS, add the height
  - Using for-loop traverse all node in the Queue, add leaves to the queue
- **Find the minimum height tree/ compute the height**
  - When the node has more than 1 left break;
## <h2 id = "implementation">Implementation</h2>
- It's better to use BFS to do the topological sort
``` Java
// Compute the in-degree of all nodes
int[] inDegree = new int[graph.size()];
int count = 0;
for(Integer i: graph.keySet()){
    inDegree[i]++;
}


// Find the node whose in-degree is 0
Queue<Integer> queue = new LinkedList<>();
for(int i = 0; i < inDegree.length; i++){
    if(inDegree[i] == 0){
        queue.offer(i);
        count++;
    }
}

// Use BFS to traverse nodes to do the topological sort
while(!queue.isEmpty()){   // this condition can be changed according to the problem
    Integer v = queue.poll();
    System.out.println(v + "->");
    for(Integer neighbour: graph.get(v)){
        inDegree[neighbour]--;
        if(inDegree[neighbour] == 0){
            count++;
            queue.offer(neighbour);
        }
    }
}

return count == graph.size();
```
