# Union Find
- [Union Find Slide from Princeton](https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf)
## Quick Find
- Data structure.
  - Integer array id[] of size N.
  - Interpretation: p and q are connected if they have the same id.
- Process
   - **Find**: Check if p and q have the same id.
   - **Union**: To merge components containing p and q, and change all entries with id[p] to id[q].
  ``` Java
      i 0 1 2 3 4 5 6 7 8 9
  id[i] 0 1 9 9 9 6 6 7 8 9
  // 5 and 6 are connected
  // 2, 3, 4, and 9 are connected
  
  // Do union of 3 and 6
  // 2, 3, 4, 5, 6, and 9 are connected
      i 0 1 2 3 4 5 6 7 8 9
  id[i] 0 1 6 6 6 6 6 7 8 6
  ``` 
- Implementation
  ``` Java
  public class QuickFind{
      private int[] id;
      public QuickFind(int N){
          id = new int[N];
          for (int i = 0; i < N; i++){
            id[i] = i;
          }
      }
      public boolean find(int p, int q){
          return id[p] == id[q];
      }
      public void union(int p, int q){
          int pid = id[p];
          for (int i = 0; i < id.length; i++){
              if (id[i] == pid){
                  id[i] = id[q];
              }
          }
      }
  }
  ```
## Quick Union
- Data structure.
  - Integer array id[] of size N.
  - Interpretation: id[i] is parent of i, and root of i is id[id[id[...id[i]...]]].

- Process
  - **Find**: Check if p and q have the same root.
  - **Union**: Set the id of q's root to the id of p's root.
  ``` Java
      i 0 1 2 3 4 5 6 7 8 9
  id[i] 0 1 9 4 9 6 6 7 8 9
  
  // 3's root is 9; 5's root is 6
  // 3 and 5 are not connected 
  // Union 3, 5
      i 0 1 2 3 4 5 6 7 8 9
  id[i] 0 1 9 4 9 6 9 7 8 9
  ```
- Implementation
  ``` Java
  public class QuickUnion{
      private int[] id;
      public QuickUnion(int N){
          id = new int[N];
          for (int i = 0; i < N; i++){
              id[i] = i;
          }
      }
      private int root(int i){
          while (i != id[i]){
              i = id[i];
          }
          return i;
      }
      public boolean find(int p, int q){
          return root(p) == root(q);
      }
      public void unite(int p, int q){
          int i = root(p);
          int j = root(q);
          id[i] = j;
      }
  }
  ```
## Path Compression
## Quick Union With Path Compression
