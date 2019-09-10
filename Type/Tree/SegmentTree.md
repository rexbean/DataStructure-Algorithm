# Segment Tree
- Summary
- [Definition](#definition)
- [Operations](#operations)
  - [Create](#create)
  - [Update](#update)
  - [Query](#query)
- [Analyze](#analyze)

## <div id = "definition">Definition</div>
We can use a real tree and the definition of the tree node is:
``` java
private class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }
}
```
or we can use an int array to represent the tree:
``` java
int[] segmentTree = new int[source.length * 4];
```
## <div id = "operations">Operations</div>
### <div id = "create">Create</div>
#### TreeNode version
```java
public TreeNode createTree(int[] source) {
    this.source = source;
    if(source == null || source.length == 0) {
        return null;
    }

    root = createHelper(source, 0, source.length - 1);
    return root;
}

private TreeNode createHelper(int[] source, int left, int right) {

    if(left == right) {
        return new TreeNode(source[left]);
    }

    int mid = left + (right - left) / 2;
    TreeNode l = createHelper(source, left, mid);
    TreeNode r = createHelper(source, mid + 1, right);

    TreeNode root = new TreeNode(l.value + r.value);
    root.left = l;
    root.right = r;
    return root;
}
```
#### Array Version
``` java
private void createTree(int[] source) {
    this.source = source;
    this.segmentTree= new int[4 * source.length];
    if(source == null || source.length == 0) {
        return;
    }
    createHelper(0, 0, source.length - 1);
}

private int createHelper(int index, int left, int right) {
    if(left == right) {
        return segmentTree[index] = source[left];
    }

    int mid = left + (right - left) / 2;
    int l = createHelper(2 * index + 1, left, mid);
    int r = createHelper(2 * index + 2, mid + 1, right);

    segmentTree[index] = l + r;
    return segmentTree[index];
}
```
### <div id = "update">Update</div>
#### TreeNode Version
``` java
public void update(int i, int value){
    if(i < 0 || i >= source.length) {
        return;
    }

    int diff = value - source[i];
    source[i] = value;
    updateHelper(root, i, diff, 0, source.length - 1);
}

private void updateHelper(TreeNode root, int i, int diff, int left, int right) {
    if(root == null) {
        return;
    }

    if(left <= i && i <= right) {
        root.value += diff;
    }

    int mid = left + (right - left) / 2;
    if(i > mid) {
        updateHelper(root.right, i, diff, mid + 1, right);
    } else {
        updateHelper(root.left, i, diff, left, mid);
    }
}
```
#### Array Version
``` java
public void update(int i, int value){
    if(i < 0 || i >= source.length) {
        return;
    }

    int diff = value - source[i];
    source[i] = value;
    updateHelper(0, i, diff, 0, source.length - 1);
}

private void updateHelper(int index, int i, int diff, int left, int right) {
    if(index >= segmentTree.length) {
        return;
    }
    if(left <= i && i <= right) {
        segmentTree[index] += diff;
    }

    int mid = left + (right - left) / 2;
    if(i > mid) {
        updateHelper(2 * index + 2 , i, diff, mid + 1, right);
    } else {
        updateHelper(2 * index + 1, i, diff, left, mid);
    }
}
```
### <div id = "query">Query</div>
There are four kind of conditions:
- The range is exctaly the range of one node (base case)
- The range is in the left half
- The range is in the right half
- The range cross the left and the right half
#### TreeNode Version
``` java
public int query(int left, int right) {
    if(left < 0 || right > source.length) {
        return Integer.MIN_VALUE;
    }

    int result = queryHelper(root, 0, source.length - 1, left, right);
    return result;
}

private int queryHelper(TreeNode root,
                        int l,
                        int r,
                        int left,
                        int right) {
    if(l == left && r == right) {
        return root.value;
    }

    int mid = l + (r - l) / 2;
    int result = 0;
    if(l <= left && mid >= right) {
        result = queryHelper(root.left, l, mid, left, right);
    } else if(mid + 1 <= left && right <= r) {
        result = queryHelper(root.right, mid + 1, r, left, right);
    } else if(left <= mid && right >= mid + 1) {
        result = queryHelper(root.left, l, mid, left, mid);
        result += queryHelper(root.right, mid + 1, r, mid + 1, right);
    }
    return result;
}
```
#### Array Version
``` java
public int sumRange(int left, int right) {
    if(left < 0 || right > source.length) {
        return Integer.MIN_VALUE;
    }

    int result = queryHelper(0, 0, source.length - 1, left, right);
    return result;
}

private int queryHelper(int index,
                        int l,
                        int r,
                        int left,
                        int right) {
    if(l == left && r == right) {
        return segmentTree[index];
    }

    int mid = l + (r - l) / 2;
    int result = 0;
    if(l <= left && mid >= right) {
        result = queryHelper(2 * index + 1, l, mid, left, right);
    } else if(mid + 1 <= left && right <= r) {
        result = queryHelper(2 * index + 2, mid + 1, r, left, right);
    } else if(left <= mid && right >= mid + 1) {
        result = queryHelper(2 * index + 1, l, mid, left, mid);
        result += queryHelper(2 * index + 2, mid + 1, r, mid + 1, right);
    }
    return result;
}
```
### <div id = "analyze">Analyze</div>
- The Time Complexity of Create Tree is O(n)
- The Time Complexity of Range Sum is O(lgn)
- The Time Complexity of Update Value is O(lgn)
