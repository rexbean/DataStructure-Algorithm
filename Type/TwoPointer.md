# Two Pointers
- [Summary](#summary)
- [Applications](#applications)

<h2 id = "summary">Summary</h2>

- **Do not forget to update the pointer value after operation!!**

<h2 id = "applications">Applications</h2>

1. Exists or not(Intersection)
2. Merge
3. Remove Duplicate
4. Separating
5. Partition

- **<h3 id = "existsOrNot">Exists or not(Intersection)</h3>**
  - One in other
  - Sum in one
- **<h3 id = "merge">Merge</h3>**
- **<h3 id = "removingDuplicate">Removing duplicate</h3>**
  - Input: The number should appear **at most n times(n != 0)**
  ``` Java
  int left = n - 1;
  int right = n;
  while(right < nums.length){
      if(nums[left - (n - 1)] != nums[right]){
          left++;
          nums[left] = nums[right];
      }
      right++;
  }
  return left + 1;
  ```
- **<h3 id ="separating">Separating</h3>**

  - **Keep Order(Same Direction)**

    ``` Java
    int left = 0;
    int right = 0;
    while(right < nums.length){
        if(nums[right] does not meet the condition){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
        right++;
    }
    ```

  - **Do not need keep Order(Opposite Direction)**

    ``` Java
    int left = 0;
    int right = nums.length - 1;
    while(left < right){
        if(nums[left] meets the condition){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = nums[left];
            right--;
        } else {
            left++;
        }
    }
    ```
  - Separate into 3 parts

    **Mid is the right pointer of the left, is the left pointer of the right**
    ``` java
    int left = 0;
    int mid = 0;
    int right = nums.length - 1;
    while(mid <= right){
        if(nums[mid] == 0){
            swap(nums, left, mid);
            left++;
            mid++;
        } else if(nums[mid] == 1){
            mid++;
        } else if(nums[mid] == 2){
            swap(nums, mid, right);
            right--;
        }
    }
    ```
- Same direction and opposite direction

  | direction | order            |
  |-----------|------------------|
  | same      | original order   |
  | opposite  | do not have order|


| #   | # of Prob | Status    | Type                       | Note                                                                                                 |
| --- | --------- | --------- | -------------------------- | ---------------------------------------------------------------------------------------------------- |
| 1   | 26        | Completed | Moving elements(duplicate) | [Removing Duplicate](#removingDuplicate)                                                             |
| 2   | 80        | Completed | Moving elements(duplicate) | [Removing Duplicate](#removingDuplicate)                                                             |
| 3   | 11        | Completed |                            | the area is determined by the lowest height                                                          |
| 4   | 344       | Completed | Reverse                    |                                                                                                      |
| 5   | 141       | Completed | Fast & Slow                | [Slow Fast Pointer](https://github.com/rexbean/L/blob/master/Type/LinkedList/LinkedList.md#slowFast) |
| 6   | 283       | Completed | Separating                 | [Separating](#separating)                                                                            |
| 7   | 75        | Completed | Separating                           |[Separating](#separating)                                                                                    |
