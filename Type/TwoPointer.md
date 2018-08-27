| #   | # of Prob | Status    | Type                       | Note               |
| --- | --------- | --------- | -------------------------- | ------------------ |
| 1   | 26        | Completed | Moving elements(duplicate) |                    |
| 2   | 80        | Completed | Moving elements(duplicate) | formula for removing duplicate|
|     |           |           |                            |                    |



## Formular for removing duplicate
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
