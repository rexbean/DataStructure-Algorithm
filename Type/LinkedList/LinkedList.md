# LinkedList
- [Summary](#summary)
  - [Corner case](#cornerCase)
- [Basic Knowledge](#basics)
  - [List Node](#listNode)
  - [Singly Linked List](#singly)
    - [Create](#singlyCreate)
    - [Insert](#singlyInsert)
      - Insert at the head
      - Insert at the tail
      - Insert in the middle
        - Insert in the specific position
        - Insert every k nodes
        - Insert in a sorted List
    - [Delete](#singlyDelete)
      - Delete the head
      - Delete the tail
      - Delete the middle
      - Deletion in O(1) time complexity
      - Delete every k nodes
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
    - [Cycle](#singlyCycle)
    - [Intersection](#singlyIntersection)
    - [Cyclic Singly Linked List](#singlyCyclic)
      - [Create](#singlyCyclicCreate)
      - [Insert](#singlyCyclicInsert)
        - Insert in particular position
      - [Delete](#singlyCyclicDelete)
      - [Find](#singlyCyclicFind)
      - [Reverse](#singlyCyclicReverse)
  - [Doubly Linked List](#doubly)
    - [Create](#doublyCreate)
## <h2 id = "summary">Summary</h2>
### **Caution！！**
  - If two pointers point to the same node, they are not same!!
  - When a new node will be added then a **pre** node will be needed!
  - When modifing the structure of the linked list, do not forget to **let the last node points to null**
### <h3 id = "cornerCase">Corner Case</h3>
- Linked List is empty;
- Linked List only have one node
- Linked list length is enough or not
## <h2 id = "basics">Basic Knowlege</h2>
### <h3 id = "listNode"> List Node</h3>
```java
class ListNode{
    public int val;
    public ListNode next;
    pubic ListNode(int val){
        this.val = val;
    }
}
```
### <h3 id = "singly">Single Linked List</h3>
#### <h4 id = "singlyCreate"> Create a Singly Linked List</h4>
```java
ListNode dummy = new ListNode(0);
ListNode cur = dummy;
while(<Some condition>){
    cur.next = new ListNode(<new Value>);
    cur = cur.next;
}
```
#### <h4 id = "singlyInsert"> Insert nodes into the singly Linked List</h4>
- Insert at the head
  ```java
  /***
  * head the head of the original list
  * newNode the new node need to insert
  * return the new head
  ***/
  public ListNode insertHead(ListNode head, ListNode newNode){
      if(head == null){
          return newNode;
      }

      newNode.next = head;
      return newNode;
  }
  ```
- Insert at the tail
  ```java
  /***
  * head: the head of the original Linked List
  * newNode: the node need to insert
  * return the head of the list
  ***/
  public ListNode inserttail(ListNode head, ListNode newNode){
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
  - Insert in a specific position
  ```java
  /***
  * head: the head of the original list
  * newNode: the node need to insert
  * pos: the position to insert
  * return the head of the list
  ***/
  public ListNode insert(ListNode head, ListNode newNode, int pos){
      if(head == null){
          return newNode;
      }
      if(newNode == null){
          return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      int index = 0;
      ListNode prev = dummy;
      // case 1: pos < length;
      // case 2: pos >= length, insert at the tail;
      while(index != pos && head != null){
          prev = head;
          head = head.next;
      }
      prev.next = newNode;
      newNode.next = head;
      return dummy.next;
  }
  ```
  - Insert every k nodes
  ``` java
  /***
  * head : the head of the original node
  * newVal : the val to insert
  * k: every k node to insert
  * return the head of the list
  ***/
  public ListNode insert(ListNode head, int newVal, int k){
      // case 1: list is empty => return null
      // case 2: list does not have enough length => return null / insert here
      // case 3: enough but has a tail
      if(head == null){
          return null;
      }
      if(k < 0){
          return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;
      while(head != null){
          int i = 0;
          while(i < k && head != null){
              prev = head;
              head = head.next;
              i++;
          }
          ListNode newNode = new ListNode(newVal);
          prev.next = newNode;
          newNode.next = head;

          if(head == null){
              return dummy.next;
          }
      }
      return dummy.next;
  }
  ```
  - Insert a new node in a sorted List
  ```java
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
#### <h4 id = "singlyDelete"> Delete nodes from the singly Linked List</h4>
- Delete the head
  ``` java
  public ListNode deleteHead(ListNode head){
      if(head == null){
          return head;
      }

      return head.next;
  }
  ```
- Delete the tail
  ``` java
  public ListNode deleteTail(ListNode head){
      if(head == null){
          return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      while(head.next != null){
          head = head.next;
      }
      head = null;

      return dummy.next;
  }
  ```
- Delete the middle
  ``` java
  /***
  * head : The head of the linked list
  * pos : the position need to delete
  * return the head of the list
  ***/
  public ListNode delete(ListNode head, int pos){
      if(head == null || pos < 0){
          return head;
      }
      int index = 0;

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      // walk till to the position
      while(head != null && index != pos){
          head = head.next;
          index++;
      }
      // if the length < pos return previous head
      if(index != pos){
          return head;
      }
      // if head is not the tail then delete
      // this method can do the Deletion in O(1) time complexity
      if(head.next != null){
          head.val = head.next.val;
          head.next = head.next.next;
      } else {
          // if it is the tail then let it be null;
          head = null;
      }
      return dummy.next;
  }
  ```

- Delete every k nodes
  ``` java
  public ListNode delete(ListNode head, int k){
      if(head == null || k < 0){
          return head;
      }

      int index = 0;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      while(head != null){
          while(head != null && index != k){
              head = head.next;
              index++;
          }
          // if the length is less then k
          if(head == null){
              return dummy.next;
          }

          if(head.next != null){
              head.val = head.next.val;
              head.next = head.next.next;
          } else {
              head = null;
          }
          index = 0;
      }

      return dummy.next;
  }
  ```
- Delete nodes with the same value
  ``` java
  public ListNode delete(ListNode head, int val){
      if(head == null || val < 0){
          return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      while(head != null){
          if(head.val == val){
              if(head.next != null){
                  head.val = head.next.val;
                  head.next = head.next.next;
              } else {
                  head = null;
              }
          } else {
              head = head.next;
          }
      }
      return dummy.next;
  }
  ```
#### <h4 id = "singlyFind"> Find nodes in the singly Linked List</h4>
- Find the middle
  ``` java
  public ListNode findMiddle(ListNode head){
      if(head == null){
          return head;
      }

      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null){
          if(fast.next.next == null){
              // slow will be the last node of the first part
          }
          fast = fast.next.next;
          slow = slow.next;
      }

      if(fast == null){
          // slow will be the first node of second part, the length of the linked list is even

      }
      if(fast.next == null){
          // slow will be the middle of the linked list, the length of the linked list is odd
      }
  }
  ```
    | Fast                  | Slow                              | # of Length |
    |-----------------------|-----------------------------------|-------------|
    |fast == null           | the first node of the second part | Even        |
    |fast.next.next == null | the last node of the first part   | Even        |
    | fast.next == null     | the middle of the linked List     | Odd         |

- Find the k-th node from the head
  ``` java
  public ListNode find(ListNode head, int k){
      if(head == null || k < 0){
          return head;
      }

      int index = 0;
      while(head != null && index != k){
          head = head.next;
          index++;
      }
      if(head == null){
          return null;
      }
      return head;
  }
  ```
- Find the k-th node from the tail
  ``` java
  public ListNode find(ListNode head, int k){
      if(head == null || k < 0){
          return head;
      }

      ListNode fast = head;
      ListNode slow = head;
      int index = 0;
      while(fast != null && index != k){
          fast = fast.next;
          index++;
      }
      if(fast == null){
          // the length of the linked list is less than k;
          return null;
      }

      while(fast != null){
          fast = fast.next;
          slow = slow.next;
      }
      return slow;
  }
  ```
#### <h4 id = "singlyReverse"> Reverse the singly linked list </h4>
- Reverse all
  ``` java
  public ListNode reverse(ListNode head){
      if(head == null){
          return head;
      }

      ListNode prev = null;
      while(head != null){
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
      }
      return prev;
  }
  ```
- Reverse half
  ``` java
  public ListNode reverse(ListNode head){
      if(head == null){
          return head;
      }

      ListNode prev = new ListNode(0);
      ListNode dummy = new ListNode(0);
      ListNode fast = head;
      ListNode slow = head;

      dummy.next = head;
      prev = dummy;

      while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
          prev = prev.next;
      }

      // here slow will be the first node of the second part or the middle

      while(slow != null){
          ListNode next = slow.next;
          slow.next = prev;
          prev = slow;
          slow = next;
      }

      // prev here will be the head of the last node of the list
      // dummy.next will be the first node of the list

  }
  ```

- Reverse in a range
  ``` java
  public ListNode reverse(ListNode head, int m, int n){
      if(head == null || m > n){
          return head;
      }

      ListNode prev = new ListNode(0);
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      prev = dummy;

      int index = 0;
      while(head != null && index != m){
          head = head.next;
          prev = prev.next;
          index++;
      }
      if(head == null){
          return head;
      }
      ListNode pre1 = pre;
      ListNode head1 = head;

      while(head != null && index != n + 1){
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
      }
      prev1.next = prev;
      head1.next = head;

      return dummy.next;
  }
  ```
- Reverse in k- group
  ```java
  public ListNode reverse(ListNode head, int k){
      if(head == null || k < 0){
          return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prev1 = dummy;
      int index = 0;
      ListNode prev = prev1;
      ListNode head1 = head;
      ListNode next = null;
      while(head != null){
          prev1 = prev;
          head1 = head;
          ListNode cur = head;
          while(cur != null && index != k){
              cur = cur.next;
              index++;
          }
          if(index < k){
              return dummy.next;
          }
          while(head != cur){
              next = head.next;
              head.next = prev;
              prev = head;
              head = next;
              index++;
          }

          prev1.next = prev;
          head1.next = head;
          prev = head1;

          index = 0;
      }

      return dummy.next;
  }
  ```
#### <h4 id = "Merge">Merge Linked List</h4>
- Merge 2 Sorted List (two pointers)
  ``` java
  public ListNode merge(ListNode l1, ListNode l2){
      if(l1 == null){
          return l2;
      }
      if(l2 == null){
          return l1;
      }

      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;

      while(l1 != null && l2 != null){
          if(l1.val > l2.val){
              cur.next = new ListNode(l2.val);
              l2 = l2.next;
          } else {
              cur.next = new ListNode(l1.val);
              l1 = l1.next;
          }
          cur = cur.next;
      }
      while(l1 != null){
          cur.next = new ListNode(l1.next);
          cur = cur.next;
          l1 = l1.next;
      }
      while(l2 != null){
          cur.next= new ListNode(l2.next);
          cur = cur.next;
          l2 = l2.next;
      }
      return dummy.next;
  }
  ```
- Merge k sorted Linke List
  ``` java
  /***
  * lists: k sorted Linked List
  * k : the number of the linked list
  * reutrn the new head of the list
  */
  public ListNode mergeKList(ListNode[] lists, int k){
      if(lists == null || lists.length == 0){
          return null;
      }

      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;

      Comparator<ListNode> comparator = new Comparator<>(){
          @Override
          public int compare(ListNode l1, ListNode l2){
              return l1.val - l2.val;
          }
      }
      PriorityQueue<ListNode> heap = new PriorityQueue<>(k, comparator);

      for(ListNode n : lists){
          if(n != null){
              heap.offer(n);
          }

      }

      while(!heap.isEmpty()){
          ListNode temp = heap.poll();
          cur.next = new ListNode(temp.val);
          cur = cur.next;

          if(temp.next != null){
              heap.offer(temp.next);
          }
      }
      return dummy.next;

  }
  ```
#### <h4 id = "singlyCycle"> Whether a singly linked list has a cycle</h4>
  ``` java
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
#### <h4 id = "singlyIntersection"> Find the intersection of the singly linkedList</h4>
  ``` java
  ListNode a = headA;
  ListNode b = headB;
  while(a != b){
      a = a == null? headB : a.next;
      b = b == null? headA : b.next;
  }
  return a;
  ```
### <h3 id = "singlyCyclic">Cyclic Linked List</h3>
#### <h4 id = "singlyCyclicCreate">Create</h4>
```java
  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;
  while(<some condition>){
    cur.next = new ListNode();
    cur = cur.next;
  }
  cur.next = dummy.next;
  return dummy.next;
```
#### <h4 id = "singlyCyclicInsertion">Insert</h4>
##### Insert in a sorted linked list
###### **Corner case**
  - head == null
  - head.next == head (only one node)
  - duplicate value
###### Stages
  - climbing stage
  - cliff
```java
public ListNode insert(ListNode head, int insertVal){
    // head == null
    if(head == null){
        head = new ListNode(insertVal);
        head.next = head;
        return head;
    }

    // head.next == head
    if(head.next == head){
        head.next = new ListNode(insertVal);
        head.next.next = head;
        return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = head.next;
    while(head != dummy.next){
        // climbing & duplicate
        if(head.val <= insertVal && head.next.val >= insertVal){
            break;
        }
        // cliff
        if(head.val > head.next.val && (head.next.val > insertVal || head.val < insertVal)){
            break;
        }
        head = head.next;
    }

    ListNode next = head.next;
    head.next = new ListNode(insertVal);
    head.next.next = next;

    return dummy.next;
  }
}
```
#### <h4 id = "singlyCyclicReverse">Reverse</h4>
```java
public ListNode reverse(ListNode head){
    if(head_ref == null){
        return head_ref;
    }

    if(head_ref.next == head_ref) {
        return head_ref;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head_ref;

    ListNode sec = head_ref.next;
    head_ref = sec;

    ListNode pre = null;
    while(head_ref != dummy.next){
        ListNode next = head_ref.next;
        head_ref.next = pre;
        pre = head_ref;
        head_ref = next;
    }

    head_ref.next = pre;
    sec.next = head_ref;
    return dummy.next;
}

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
| 16  | 24        | Completed  |                         |                                                                                |
