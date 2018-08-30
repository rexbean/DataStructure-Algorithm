# Topological Sort
- [implementation](#implementation)

| #   | # of Prob | Status    | Type             | note |
| --- | --------- | --------- | ---------------- | ---- |
| 1   | 207       | Completed | Topological Sort |      |
| 2   | 210       | Completed | Topological Sort |      |
| 3   | 444       | To be Done | Topological Sort | judge whether a graph's nodes are in the order of other sequence     |

## <h2 id = "implementation">Implementation</h2>
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
