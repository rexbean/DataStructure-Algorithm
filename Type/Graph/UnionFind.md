# Union Find
- [Union Find Slide from Princeton](https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf)
- [Quick Find](#quickFind)
- [Quick Union](#quickUnion)
- [Weighted Quick Union](#WQU)
- [Path Compression](#pathCompression)
## <h2 id = "quickFind">Quick Find</h2>
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
## <h2 id ="quickUnion">Quick Union</h2>
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
## Analysis
- Quick-find defect.
  - Union too expensive (N steps).
  - Trees are flat, but too expensive to keep them flat.
- Quick-union defect.
  - Trees can get tall.
  - Find too expensive (could be N steps)
  - Need to do find to do union
 
    | algorithm | union | find |
    |-----------|-------|------|
    | quick Find |  N | 1 |
    | quick union | N* | N |
    \* includes of the cost of find
## Improvement
### <h3 id = "WQU">Weighted Quick Union<h3>
- Modify quick-union to avoid tall trees.
- Keep track of size of each component.
- Balance by linking small tree below large one.
- Process
  - Find: Identical to quick-union.
  - Union: Modify quick-union to
    - merge smaller tree into larger tree
    - update the sz[] array.
- Implementation
  ``` Java
  public class QuickUnion{
      private int[] id;
      private int[] sz;
      public QuickUnion(int N){
          id = new int[N];
          sz = new int[N];
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
          if(sz[i] < sz[j]){
              id[i] = j;
              sz[j] += sz[i];
          } else {
              id[j] = i; 
              sz[i] += sz[j];
          }
      }
  }
  ```
- Analysis
  - Find: takes time proportional to depth of p and q.
  - Union: takes constant time, given roots.
  - Fact: depth is at most lg N. 
  
  | Algorithm | Union | Find |
  |-----------| ------| -----|
  |Quick Find | N| 1|
  |Quick Union| N*| N|
  |WQU| lgN*|LgN|   
  \* includes of the cost of find
## <h2 id ="pathCompression">Path Compression<h2>
## Quick Union With Path Compression
