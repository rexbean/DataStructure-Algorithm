# LinkedList

| #   | # of prob | Status    | Type         | Note                                                                                                                                                                          |
| --- | --------- | --------- | ------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | 206       | Completed | Reverse all | one for pre<br> one for current<br> one for next                                                                                                                              |
| 2   | 237       | Completed | pointer      | Given a node wanted to delete<br> just give it the next node's value and link.                                                                                                |
| 3   | 203       | Completed | pointer      | 1. When Deleting node, always use the previous node to determine whether delete next node or not.<br> 2. After deleting, do not jump to next, continue to judge the next one. |
| 4   | 83        | Completed | Two Pointers | After deleting, do not jump to next, continue to judge the next one.                                                                                                          |
| 5   | 92        | Completed | Reverse a range             | `ListNode pre1 = pre;`<br>`ListNode head1 = head;`<br>`while(head != null && curIndex != n + 1){`<br> `ListNode next = head.next;`<br>`head.next = pre;`<br>`pre = head;`<br>`head = next;`<br>`curIndex++;`<br>`}`<br>`pre1.next = pre;`<br>`head1.next=head;`|
