# Two Pointers

[Summary](#summary)

<h2 id = "summary">Summary</h2>
- **Do not forget to update the pointer value after operation!!**
- **<div id = "removingDuplicate">Formular for removing duplicate</div>**
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


| #   | # of Prob | Status    | Type                       | Note                                        |
| --- | --------- | --------- | -------------------------- | ------------------------------------------- |
| 1   | 26        | Completed | Moving elements(duplicate) | [Removing Duplicate](#removingDuplicate)    |
| 2   | 80        | Completed | Moving elements(duplicate) | [Removing Duplicate](#removingDuplicate)    |
| 3   | 11        | Completed |                            | the area is determined by the lowest height |
| 4   | 344       | Completed | Reverse                    |                                             |
