# LinkedList
- [Summary](#summary)
- [Basic Knowledge](#basics)
  - [List Node](#listNode)
  - [Singly Linked List](#singly)
    - [Create](#singlyCreate)
    - [Insert](#singlyInsert)
      - Insert at the head
      - Insert at the end
      - Insert in the middle
    - [Delete](#singlyDelete)
      - Delete the head
      - Delete the end
      - Delete the middle
      - Deletion in O(1) time complexity
      - Delete any k nodes
      - Delete nodes with the same value
    - [Find](#singlyFind)
      - Find the middle
      - Find the kth node from head
      - Find the kth node from tail
    - [Reverse](#singlyReverse)
      - Reverse all
      - Reverse half
      - Reverse in a range
      - Reverse in k-group
    - [Merge](#singlyMerge)
      - Merge two sorted Linked List
      - Merge K sorted Linked List
    - [Circular Singly Linked List](#singlyCircular)
      - Create
      - Insert
        - Insert in particular position
      - Delete
      - Find
  - [Doubly Linked List](#doubly)
    - [Create](#doublyCreate)
## <h2 id = "summary">Summary</h2>

## <h2 id = "basics">Basic Knowlege</h2>
### <h3 id = "listNode"> List Node</h3>
```Java
class ListNode{
    public int val;
    public ListNode next;
    pubic ListNode(int val){
        this.val = val;
    }
}
```
### <h3 id = "singlyCreate"> Create a Singly Linked List</h3>
```Java
ListNode dummy = new ListNode(0);
ListNode cur = dummy;
while(<Some condition>){
    cur.next = new ListNode(<new Value>);
    cur = cur.next;
}
```
### <h3 id = "singlyInsert"> Insert a node into the singly Linked List</h3>
- Insert at the head
  ```Java
  /***
  * head the head of the original list
  * newNode the new node need to insert
  * return the new head
  ***/
  public ListNode insertHead(ListNode head, ListNode newNode){
      if(ListNode == null){
          return head;
      }

      newNode.next = head;
      return newNode;
  }
  ```
- Insert at the end
  ```Java
  /***
  * head: the head of the original Linked List
  * newNode: the node need to insert
  * return the head of the list
  ***/
  public ListNode insertEnd(ListNode head, ListNode newNode){
      if(head == null){
          return newNode;
      }
      if(newNode == null){
          return head;
      }
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      while(head.next != null){
          head = head.next;
      }
      head.next = newNode;
      return dummy.next;
  }
  ```
- Insert in the middle
  - Insert a new node in a sorted List
  ```Java
  public ListNode insert(ListNode head, ListNode newNode){
      if(head == null){
          return newNode;
      }
      if(newNode == null){
          return head;
      }
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prev = dummy;
      while(head!= null){
          // case 1: climbing (ascending)
          if(newNode.val <= head.val){
              prev.next = newNode;
              newNode.next = head;
              return dummy.next;
          }
          prev = head;
          head = head.next;
      }
      if(prev.val < newNode.val){
          prev.next = newNode;
          return dummy.next;
      }
      return dummy.next;

  }
  ```
- Every time, **walk a Linked List**, **define a dummy node before**, let it next be head.

- **<div id = "delete">Delete</h2>**
  - **After deleted, do not jump to next node! Judge the new next first!**

  ```Java
  if(current.next.val == val){
      current.next = current.next.next;
  } else {
      current = current.next;
  }
  ```
- **<div id ="reverse">Reverse</div>**
  - Reverse all

  ```Java
  ListNode pre = null;
  ListNode cur = head;
  while(head != null){
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
  }
  ```
  - Reverse node in a range

  ``` Java
  // now current is the first node need to be reversed
  // pre is the node before the current;
  // right is the index of the last node need to be reversed
  ListNode pre1 = pre;
  ListNode head1 = head;
  while(current != null && currentIndex != right + 1){
      ListNode next = current.next;
      current.next = pre;
      pre = current;
      current = next;
  }
  pre1.next = pre;
  head1.next = current;
  // !!! do not forget let the pre be the node before the head!!
  while(pre.next != head){
      pre = pre.next;
  }

  ```
- **<div id = "slowFast">Slow Fast Two Pointers</div>**
  - **get the middle of the linkedList**.
    ``` Java
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    ```


    | # of nodes | Fast              | Slow                                  |
    | ---------- | ----------------- | ------------------------------------- |
    | Odd        | fast.next => null | Slow => middle                        |
    | Even       | fast =>null       | Slow => First node of the second part |


  - **Judge whether a linked List has a cycle**
    ``` Java
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(slow == fast){
            return true;
        }
    }
    return false;
    ```
  - **get the node which is the i-th node from the end**
- **<div id = "intersection">Intersection <div>**
  ``` Java
  ListNode a = headA;
  ListNode b = headB;
  while(a != b){
      a = a == null? headB : a.next;
      b = b == null? headA : b.next;
  }
  return a;

  ```
| #   | # of prob | Status     | Type                    | Note                                                                           |
| --- | --------- | ---------- | ----------------------- | ------------------------------------------------------------------------------ |
| 1   | 206       | Completed  | Reverse all             | [Reverse](#reverse)                                                            |
| 2   | 237       | Completed  | pointer                 | Given a node wanted to delete<br> just give it the next node's value and link. |
| 3   | 203       | Completed  | pointer                 | [Delete](#delete)                                                              |
| 4   | 83        | Completed  | Two Pointers            | [Delete](#delete)                                                              |
| 5   | 92        | Completed  | Reverse a range         | [Reverse](#reverse)                                                            |
| 6   | 234       | Completed  | Two Pointers<br>reverse | Find the middle, reverse, compare                                              |
| 7   | 2         | Completed  | Add                     | [Note.add](https://github.com/rexbean/L/blob/master/Type/note.md#add)          |
| 8   | 21        | Completed  | Merge                   | [Note.merge](https://github.com/rexbean/L/blob/master/Type/note.md#merge)      |
| 9   | 148       | To be Done | Sort                    |                                                                                |
| 10  | 147       | To be Done | Sort                    |                                                                                |
| 11  | 138       | To be Done | Copy                    |                                                                                |
| 12  | 25        | Completed  | Reverse                 | [Reverse](#reverse)                                                            |
| 13  | 143       | Completed  | Reverse                 | [Reverse](#reverse), it can reverse the second half                            |
| 14  | 160       | Completed  | Intersection            | [Intersection](#intersection)                                                  |
| 15  | 817       | Completed  | Connectivity            |                                                                                |
