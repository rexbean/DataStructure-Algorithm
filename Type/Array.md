# Array
- [Basics](#basics)
- [Algorithms](#algorithms)
- [Corner case](#cornerCase)

## <div id = "basics">Basics</div>
- An array has length of n, has n sub array.
- Two demensional array indices(i for row, j for column):
  - main diagonal:
    - From starter point(**[i][i]**) every time, **i += 1, j += 1**
  - antidiagonal:
    - From starter point(**[i][column - 1 - i]**) everytime, **i += 1, j -= 1**

## <div id ="algorithms">Algorithms</div>
- [prefix Sum](#prefixSum)
- [Sliding window](#outer_link)
- [Two pointers](#outer_link)
### <div id = "prefixSum">prefix Sum </div>
  - Problem related to the subarray sum always using **prefix Sum**
    ```Java
    for(int i = 0; i < nums.length; i++){
        preSum += num[i];
        // do something with prefix Sum
    }
    ```
#### Application
- Two indices, i and j, are specified
  - Statically will use **prefix sum**<---**Using Array**
    ```java
    preSum[0] = 0;
    rangeSum = preSum[j + 1] - preSum[i];
    ```
  - Dynamically will use **index tree** or **segment tree**
- Finding a subarray whose sum meets some requirement <---**Using map or nothing**
  ```java
  sum.put(0, 1);
  preSum += nums[i];
  // find the sum which meets the requirement
  sum.put(preSum);
  ```
## <h2 id = "cornerCase">Corner Case</h2>
- all equal
- all 0s
- the combination of positives and negatives

| #   | # of Prob | Status    | Type                                                              | Note                                                                          |
| --- | --------- | --------- | ----------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| 1   | 53        | Completed | Prefix Sum                                                        | 1. [prefixSum](#prefixSum)<br> 2. max subArray => Math.max(max, preSum - min) |
| 2   | 560       | Completed | Prefix Sum                                                        |                                                                               |
| 3   | 561       | Completed | -                                                                 | The larger one will be hidden, so using the second large to hide it.          |
| 4   | 66        | Completed | Add                                                               | [Note.add](https://github.com/rexbean/L/blob/master/Type/note.md#add)         |
| 5   | 122       | Completed | Math                                                              | profit = sumOf(sell - buy), when sell > buy                                   |
| 6   | 31        | Completed | Find the rule                                                     |                                                                               |
| 7   | 442       | Completed | Flip the nums[nums[i]], if it already negative, it appeared twice |                                                                               |
| 8   | 495       | Completed | Merge interval                                                    |                                                                               |
| 9   | 307       | Completed | Prefix Sum                                                        | Dynamically computed the range sum using Index tree                           |
|     |           |           |                                                                   |                                                                               |
