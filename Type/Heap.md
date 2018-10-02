# Heap
- [Summary](#summary)


## <h2 id = "summary">Summary</h2>

## <h2 id = "application">Application</h2>
- Dynamically get the max/ min value no matter add or remove any values including the current max/ min value;
- Get the value with the max priority.
- Always return the k-th largest/ smallest priority element
  To get the k-th largest element, we maintain a min-heap with size k, everytime return heap.peek();
  ``` java
  public int kthLargest(int[] nums, int k){
      if(nums == null || nums.length == 0 || k < 0){
          return -1;
      }

      PriorityQueue<Integer> heap = new PriorityQueue<>();

      for(int i = 0; i < nums.length; i++){
          if(heap.size() < k){
              heap.offer(nums[i]);
          } else if(heap.peek() < nums[i]){
              heap.poll();
              heap.offer(nums[i]);
          }
      }
      return heap.peek();
  }

  ```
- arrange same element can not be adjacent
- Implement Djkistra algorithm using heap
 Implemented by **Priority Queue**

| #   | # of Prob | Status     | Note                                                                               |
| --- | --------- | ---------- | ---------------------------------------------------------------------------------- |
| 1   | 239       | To be Done |                                                                                    |
| 2   | 23        | Completed  | [Note.merge](https://github.com/rexbean/L/blob/master/Type/note.md#merge)          |
| 3   | 347       | Completed  | [Note.KFrequent](https://github.com/rexbean/L/blob/master/Type/note.md#kFrequency) |
| 4   | 703       | Completed  |                                                                                    |
| 5   | 451       | Completed  | Bucket sort + heap                                                                 |
| 6   | 692       | Completed  | Top k frequent                                                                                   |


# Priority Queue
