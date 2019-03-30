# Sort
| Name                        | Average   | Worst Time | Space    | Stability |
| --------------------------- | --------- | ---------- | -------- | --------- |
| [Bubble](#bubbleSort)       | O(n^2)    | O(n^2)     | O(1)     |           |
| [Selection](#SelectionSort) | O(n^2)    | O(n^2)     | O(1)     |           |
| [Insertion](#insertionSort) | O(n^2)    | O(n^2)     | O(1)     |           |
| [Quick](#quickSort)(Outer)  | O(nlg(n)) | O(n^2)     | O(n)     | unstable  |
| [Merge](#mergeSort)         | O(nlg(n)) | O(nlg(n))  | O(lg(n)) |           |
| [Heap](#heapSort)           | O(nlg(n)) | O(nlg(n))  | O(1)     |           |
| Shell                       |           |            |          |           |
| Radix                            |           |            |          |           |

**Stability represents whether the result can maintain the original order of two equal number**
## <div id = "bubbleSort">Bubble Sort</div>
### Definition
  - Repeatedly swapping the adjacent number, if they are in wrong order.
  - At the end of each loop, the max/min number of the unsorted area has been moved to the right place.
### Implementation
  ```java
  public void bubbleSort(int[] nums){
      if(nums == null || nums.length == 0){
          return;
      }

      int len = nums.length;
      for(int i = 0; i < len - 1; i++){
          for(int j = 0; j < len - i - 1; j++){
              if(nums[j] > nums[j + 1]){
                  int temp = nums[j + 1];
                  nums[j + 1] = nums[j];
                  nums[j] = temp;
              }
          }
      }
  }
  ```
## <div id="selectionSort">Selection sort</div>
### Definition
- Everytime find the max/min number in the unsorted area then set it in the right place
### Implementation
```java
public void selectionSort(int[] nums){
    if(nums == null || nums.length == 0){
        return;
    }

    int len = nums.length;
    for(int i = 0; i < len; i++){
        int min = Integer.MAX_VALUE;
        int minIndex = i; // here is the most important one
        for(int j = i; j < len; j++){
            if(nums[j] < min){
                min = nums[j];
                minIndex = j;
            }
        }

        int temp = nums[i];
        nums[i] = min;
        nums[minIndex] = temp;
    }
}
```

## <div id = "insertionSort">Insertion Sort</div>
### Definition
- The numbers are divided into two parts, sorted and unsorted. Every time pick up a number from the unsorted numbers and insert into the right place in to the sorted area.
- Implementation
  ```java
  public void insertionSort(int[] nums){
      if(nums == null || nums.length == 0){
          return ;
      }
      int len = nums.length;
      for(int i = 1; i < len; i++){
          int temp = nums[i];
          int j = i - 1;
          while(j >= 0 && nums[j] > temp){
              nums[j + 1] = nums[j];
              j--;
          }
          nums[j + 1] = temp;
      }
  }
  ```
## <div id ="quickSort">Quick Sort</div>
### Definition
-
## Merge Sort
- Definition
- Implementation
  ```java
  public int[] mergeSort(int[] nums){

      helper(0, nums.length - 1, nums);
      return nums;
  }

  private void helper(int left, int right, int[] nums){
      if(left >= right){
          return;
      }
      int mid = left + (right - left) / 2;
      helper(left, mid, nums);
      helper(mid + 1, right, nums);
      merge(left, mid, right, nums);
  }

  private void merge(int start, int mid, int end, int[] nums){
      int[] temp = new int[end - start + 1];
      int left = start;
      int right = mid;
      int end1 = right + 1;
      int end2 = end + 1;
      int index = 0;
      while(left < end1 && right < end2){
          if(nums[left] < nums[right]){
              temp[index] = nums[left];
              left++;
          } else {
              temp[index] = nums[right];
              right++;
          }
          index++;
      }

      while(left < end1){
          temp[index] = nums[left];
          index++;
          left++;
      }

      while(right < end2){
          temp[index] = nums[right];
          index++;
          right++;
      }

      index = 0;
      for(int i = start; i < end; i++){
          nums[i] = temp[index++];
      }
  }

  ```


## Bucket Sort
## Quick Sort
