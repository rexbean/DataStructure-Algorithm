# Binary Search
- [Summary](#summary)
- [Procedure](#procedure)
- [Application](#application)
- [Template](#template)

## <h2 id = "summary">Summary</h2>
- **Caution!!!**
  - When using binary search, the array should be sorted!!
  - Pay attention to the numbers with duplicate.
  - first appearance
    ```Java
    while(){
        ...
        if(nums[mid] == target){
            right = mid;
        }
        ...
    }
    ```
  - last appearance
    ```Java
    while(){
        ...
        if(nums[mid] == target){
            left = mid;
        }
        ...
    }
    ```
  - Analysis the last two

    Target can have 5 conditions, from the picture below analyze the return value.
    ``` Java
           [left]      [right]
        1     2     3     4    5
    ```


| #   | # of Prob | Status    | Note                                      |
| --- | --------- | --------- | ----------------------------------------- |
| 1   | 153       | Completed | find out the condition of the target      |
| 2   | 852       | Completed | A[mid]> A[mid - 1] && A[mid] > A[mid + 1] |
| 3   | 349       | Completed | Find a number                             |
| 4   | 825       | Completed | Pay attention to the equal number         |

## <h2 id = "procedure">Procedure</h2>
- Find out the target or the features of the target
- Find out the condition to return
- Find out the condition to move the left / right pointer

## <h2 id = "application">Application</h2>
- If the problem is to find a number, it has big probability to use binary search.
- If the problem is to find a number in a sorted array,it must be binary search.
- If the problem is to find the range the number in, it can use binary search.
- Binary search can also be used to find the boundary of two type.

## <h2 id = "template">Template</h2>
``` Java
int left = 0;
int right = length - 1;
while(left + 1 < right){
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){
        return mid;
    } else if(nums[mid] < target){
        left = mid;
    } else {
        right = mid;
    }
}
if(nums[left] < nums[right]){
    return left;
}
return right;
```
