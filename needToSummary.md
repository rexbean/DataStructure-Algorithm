# need to summary
## two pointers - slow & fast pointers
## two pointers - sliding window
## two pointers - prefixSum/ prefixProduct
## two pointers - fast & slow pointer
### in linkedList
+ remove kth node from back
+ rotate List
+ cycle in linkedList
    + whether has cycle
        + fast = fast.next.next
        + slow = slow.next
        + fast = slow ---> have cycle
    + the begin node of cycle
        + while(head != slow.next)
        + head is the begin node of the cycle
## linkedList
- using head.next -> while head != null
- using head.next.next -> while head.next != null
- create new linkedlist, new dummy node, new head = dummynode,
    - in loop: head.next = new ListNode(0);
               head = head.next;

## Reservoir sampling
## BFS
when has the map,
- inBound(row, column, x, y)
- can walk many time ?
- how many times will each cell be walked?
    - 1,
        - data can be changed ?
            - change to other '0'
        - data cannot be changed
            - visited array
    - many times
        - change to other '0' then change back
## DFS
- Subset
- permutation
- combination
- partition into several parts
- when the number of parameters is not equal to the original one should have a helper function, otherwise it does not need.
## Anagram (49, 438, 242)
- using hashmap for Two
- using sliding window for subarray
## 2 sum/ 3 sum / 4 sum /  sum closet

## priority queue
