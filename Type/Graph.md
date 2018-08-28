# Graph
## Node
``` Java
class Node{
    int x;
    List<Node> children;
    public Node(int x, ArrayList<Node> children){
        this.x = x;
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

### Build Graph
