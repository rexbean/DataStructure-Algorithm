# LinkedList
- [Summary](#summary)
## <h2 id = "summary">Summary</h2>
1. Using slow, fast two pointer can get the middle of the linkedList.
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

2. Generate a new Linked List
    ``` Java
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while(<some conditions>){
        cur.next = new ListNode(<new Value>);
        cur = cur.next;
    }
    ```
3. Every time, walk a Linked List, define a dummy node before, let it next be head.

| #   | # of prob | Status    | Type                    | Note                                                                                                                                                                                                                                                                                                                        |
| --- | --------- | --------- | ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | 206       | Completed | Reverse all             | one for pre<br> one for current<br> one for next                                                                                                                                                                                                                                                                            |
| 2   | 237       | Completed | pointer                 | Given a node wanted to delete<br> just give it the next node's value and link.                                                                                                                                                                                                                                              |
| 3   | 203       | Completed | pointer                 | 1. When Deleting node, always use the previous node to determine whether delete next node or not.<br> 2. After deleting, do not jump to next, continue to judge the next one.                                                                                                                                               |
| 4   | 83        | Completed | Two Pointers            | After deleting, do not jump to next, continue to judge the next one.                                                                                                                                                                                                                                                        |
| 5   | 92        | Completed | Reverse a range         | `ListNode pre1 = pre;`<br>`ListNode head1 = head;`<br>`while(head != null && curIndex != n + 1){`<br> &emsp;&emsp;`ListNode next = head.next;`<br>&emsp;&emsp;`head.next = pre;`<br>&emsp;&emsp;`pre = head;`<br>&emsp;&emsp;`head = next;`<br>&emsp;&emsp;`curIndex++;`<br>`}`<br>`pre1.next = pre;`<br>`head1.next=head;` |
| 6   | 234       | Completed | Two Pointers<br>reverse | Find the middle, reverse, compare                                                                                                                                                                                                                                                                                           |
| 7   | 2         | Completed | Add | [Note.add](https://github.com/rexbean/L/blob/master/note.md#add) |
