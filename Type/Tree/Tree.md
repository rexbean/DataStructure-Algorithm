# Tree
- [Summary](#summary)
- [Concept](#concept)

<h2 id = "summary">Summary</h2>
- Recursion should think three things
  1. End condition
  2. What should every method do

- Top-down always does not have a return value;(Operation)
- Bottom-up always has a return value;(Return value determine what to do next)


- Bottom-Up should think about:
  - the return value of the leaf
  - The operation of the smallest part, maybe one node, maybe two nodes



## <h2 id = "concept">Concept</h2>
- [Tree](#tree)
- [Binary Tree](#binaryTree)
- [Binary Search Tree](#bst)
### <h3 id = "tree">Tree</h3>
  - **What is a Tree**

    Tree is a non-linear data structure, which organizes data hieractically. Data are stored in **Nodes**,and nodes are connected by **Edges**.
  - **Node**
    ``` Java
    class Node{
        int val;
        ArrayList<Node> children;
        public Node(int val){
            this.val = val;
            children = new ArrayList<>();
        }
    }
    ```
    - Node can have zero or more children.
    - Every node can have only one parent.
    - Every node can have their subtrees.
  - **Root**: The first node which does not have any parent.
  - **Degree**:
    - Node's degree: The number of children the node has.
    - Tree's degree: The maximum degree the nodes' have.
  - **Leave**: The node whose degree is 0;
  - **Level**: The root's level is **1**.
  - **Height**: The height of the tree is the length of the longest path from root to leaf.
  - **Depth**: The length of the path from node to the root.
  - **Property**
    1. **One Root**: Tree has only one root
    2. **No Ring**: It does not have any ring!!!
### <h3 id = "binaryTree">Binary Tree</h3>
#### Definition
  Binary tree is a tree that the number of any node's children is at most 2.
#### Property
  1. The number of node on level i is maximum: **2^(i - 1)(i >= 1)**
  2. The binary tree whose height is k has at most **2^k - 1 nodes.**
  3. N nodes can build a binary tree whose height is at least **lgn+1**
  4. n0 represents the number of nodes which has no children.
  <br>n2 represents the number of nodes which has 2 children.
  <br>**no = n2 + 1**;
#### Special Binary Tree
- **Full Binary Tree**
  - A tree whose whose all nodes have 2 children.
  - If it's height is h, and the number of nodes are **2^h - 1**;
![Full_Binary_Tree](assets/markdown-img-paste-20180906160359186.png)
  - [Judge a full binary tree](#judgeFullBT)
- **Complete Binary Tree**
  - A tree whose each level must be all filled, except the last level. The nodes are as far left as possible.
  ![Complete_Binary_Tree](assets/markdown-img-paste-20180906161804893.png)
  - Full binary tree is a special complete binary tree.
  - [Judge a complete binary Tree](#judgeCompleteBT)
#### Traversal
##### Inorder Traversal
- Recursion
```java
public void inorder(TreeNode root){
    if(root == null){
        return;
    }

    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
}
```
- Stack
``` java
public void inorder(TreeNode root){
    if(root == null){
        return;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    while(root != null){
        stack.push(root);
        root = root.left;
    }
    while(!stack.isEmpty()){
        TreeNode r = stack.pop();
        result.add(r.val);
        if(r.right != null){
            r = r.right;
            while(r != null){
                stack.push(r);
                r = r.left;
            }
        }
    }
    return result;
}
```

### <h3 id = "bst"><a href = "https://github.com/rexbean/L/blob/master/Type/Tree/BST.md">Binary Search Tree</a></h3>




| #   | # of Prob | Status    | Type              | Note                                                                         |
| --- | --------- | --------- | ----------------- | ---------------------------------------------------------------------------- |
| 1   | 104       | Completed | BFS               | BFS can get the depth                                                        |
| 2   | 226       | Completed | Top-Down          |                                                                              |
| 3   | 617       | Completed | like<br>Bottom-Up |                                                                              |
| 4   | 100       | Completed | Bottom-Up         |                                                                              |
| 5   | 110       | Completed | Bottom-Up         |                                                                              |
| 6   | 108       | Completed | Top-Down          | `if(left > right) return null;`<br> `mid + 1 => right`<br> `left => mid - 1` |
| 7   | 235       | Completed | LCA with BST      |                                                                              |
| 8   | 669       | Completed | Bottom-Up         | `if(L<=root.val<=R) root.left = left;root.right =right;`                     |
| 9   | 101       | Completed | Bottom-Up         |                                                                              |
| 10  | 654       | Completed | Top-Down          | `if(left > right) return null;`<br> `mid + 1 => right`<br> `left => mid - 1` |
| 11  | 236       | Completed | LCA               |                                                                              |
| 12  | 105       | Completed | Pre + In =>Tree   | Mengbi                                                                             |
