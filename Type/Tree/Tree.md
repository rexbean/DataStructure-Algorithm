# Tree
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



- Recursion should think three things
  1. End condition
  2. What should every method do

- Top-down always does not have a return value;(Operation)
- Bottom-up always has a return value;(Return value determine what to do next)


- Bottom-Up should think about:
  - the return value of the leaf
  - The operation of the smallest part, maybe one node, maybe two nodes
