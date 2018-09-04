# LinkedList
- [Summary](#summary)
## <h2 id = "summary">Summary</h2>
- Every time, **walk a Linked List**, **define a dummy node before**, let it next be head.

- Using slow, fast two pointer can **get the middle of the linkedList**.
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

- **Generate a new Linked List**
    ``` Java
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while(<some conditions>){
        cur.next = new ListNode(<new Value>);
        cur = cur.next;
    }
    ```
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

  ```
-
| #   | # of prob | Status    | Type                    | Note                                                                                                                                                                                                                                                                                                                        |
| --- | --------- | --------- | ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | 206       | Completed | Reverse all             | [reverse](#reverse)                                                                                                                                                                                                                                                                            |
| 2   | 237       | Completed | pointer                 | Given a node wanted to delete<br> just give it the next node's value and link.                                                                                                                                                                                                                                              |
| 3   | 203       | Completed | pointer                 | 1. When Deleting node, always use the previous node to determine whether delete next node or not.<br> 2. After deleting, do not jump to next, continue to judge the next one.                                                                                                                                               |
| 4   | 83        | Completed | Two Pointers            | After deleting, do not jump to next, continue to judge the next one.                                                                                                                                                                                                                                                        |
| 5   | 92        | Completed | Reverse a range         | [reverse](#reverse) |
| 6   | 234       | Completed | Two Pointers<br>reverse | Find the middle, reverse, compare                                                                                                                                                                                                                                                                                           |
| 7   | 2         | Completed | Add                     | [Note.add](https://github.com/rexbean/L/blob/master/Type/note.md#add)                                                                                                                                                                                                                                                            |
| 8   | 21        | Completed | Merge                        |                                    [Note.merge](https://github.com/rexbean/L/blob/master/Type/note.md#merge)                                                                                                                                                                                                                                                                                         |
