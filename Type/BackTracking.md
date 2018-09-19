# BackTracking
- [Summary](#summary)
- [Procedure](#procedure)
- [Application](#application)

## <h2 id = "summary">Summary</h2>
- **Caution!!**
  - Pay attention to the duplicate
  - When using start variable, the loop variable is **i not start**
- Remove Duplicate
  - **Removing duplicate resulting from duplicate input should sort the source first!!**
  - Permutation
    - use a used array/ HashSet to let one element only used once.
    - use !used[i - 1] && nums[i - 1] == nums[i] continue; to solve the duplicate resulting from the duplicate input.
  - Combination
    - use start to let one combination only appear once.
      - i => start, the element can be used more than once
      - i + 1=>start, the element can only be used once.
    - use i! = start && nums[i - 1] == nums[i] continue to solve the duplicate resulting from the duplicate input.


## <h2 id = "procedure">Procedure</h2>
- Find out the end point!
- Find out the restriction
- Find out what should be done for each element(recursion tree)
- Find out the parameters
- Find out the a memory cache

## <h2 id = "applications">Applications</h2>
- If a problem is related to combination and permutation, it may be a backtracking problem
- Cut
- Concatenate


| #   | # of Prob | Status     | Note                                                                        |
| --- | --------- | ---------- | --------------------------------------------------------------------------- |
| 1   | 784       | Completed  | sub = sub.substring()                                                       |
| 2   | 526       | Completed  | used array && start Index                                                   |
| 3   | 22        | Completed  | sub = sub.substring(start, end + 1)                                         |
| 4   | 46        | Completed  | used array                                                                  |
| 5   | 216       | Completed  | choose a good end condition                                                 |
| 6   | 51        | Completed  |                                                                             |
| 7   | 52        | Completed  | two array,<br> left diagnal: row - col + n - 1,<br>right diagnal: row + col |
| 8   | 47        | Completed  |                                                                             |
| 9   | 90        | Completed  | Duplicate of Combination                                                    |
| 10  | 131       | Completed  | Cut String                                                                  |
| 11  | 320       | To be Done | Contatate                                                                            |
|     |           |            |                                                                             |
