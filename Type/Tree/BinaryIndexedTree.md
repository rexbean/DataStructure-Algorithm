# Binary Indexed(Fenwick) Tree
- Summary
- [Definition](#definition)
  - [Preparation](#preparation)
  - [Basic Idea](#basicIdea)
- [Operations](#operations)
  - [Create](#create)
  - [Update](#update)
  - [Range Sum](#rangeSum)
- [Analyze](#analyze)
- [Application](#application)

## <div id = "definition">Definition</div>
The main purpose of the Binary Indexed tree is to do the **Update** and **Range Sum** operations on an array in O(lgn) time Complexity with simple code.
The other data structure which can make this happen is [Segment Tree](../SegmentTree.md), but it should write long code to implement that.

### <div id = "preparation">Preparation</div>
The basic of **Binary Indexed Tree** is **isolating the last set bit**
- What is last set bit?</br>
For example, the last set bit of 1010(binary) is the second bit from tail is the last set bit, which represents 2.
- How to isolating that?</br>
Using formula **x & (-x)**, can get the last set bit.
- Prove
  - Assume x =  a1b, where a are a lot 1s and 0s, b only have a lot of 0s.
  - Then  -x = (a1b)' + 1 = a'0b'(1...111)+ 1 = a'1b(0...000)
  - Then   x & -x = (0...000)1(0...000)
  - Now the last set bit is isolated
### <div id = "basicIdea">Basic Idea</div>
Each integer can be represented as the sum of powers of two. Similarly, the prefix sum of a given array can be computed in the same way. Each index of the BIT[] will store a partial sum of the original array; When a prefix sum needed, it can be computed by accumulating some partial sum in BIT[];

The relationship between the index of BIT[] and the partial sum in it.
At the index i, it will store the partial sum of the range[i - last set bit + 1, i]
## <div id = "operations">Operations</div>
### <div id = "create">Create</div>
When creating the BIT[], it will just do the update() operation on each element in the source array.
### <div id = "update">Update</div>
``` java
public void update(int i, int val) {
    while(i <= n) {
      BIT[i] += val;
      i += i &(-i);
    }
}
```
### <div id = "rangeSum">Range Sum</div>
```java
int rangeSum(int x) {
     int sum = 0;
     while(i > 0) {
       sum += BIT[i];
       i -= (i & (-i));
     }
     return sum;
}
```
## <div id = "analyze">Analyze</div>
- Time Complexity for update: O(lgn)
- Time Complexity for range sum: O(lgn)
- Space Complexity for Binary Indexed Tree: O(n)

## <div id = "application">Application</div>
Before using Binary indexed tree, one thing should be confirmed that the operation or the function is: Associative, which means f(f(a,b), c) = f(a, f(b,c)).
