# Array
- [Summary](#summary)

<h2 id = "summary">Summary</h2>

- **<div did ="prefixSum">Subarray** always using **prefix Sum</div>**

  ```Java
  for(int i = 0; i < nums.length; i++){
      preSum += num[i];
      // do something with prefix Sum
  }
  ```

| #   | # of Prob | Status     | Type       | Note                                                                          |
| --- | --------- | ---------- | ---------- | ----------------------------------------------------------------------------- |
| 1   | 53        | Completed  | Prefix Sum | 1. [prefixSum](#prefixSum)<br> 2. max subArray => Math.max(max, preSum - min) |
| 2   | 560       | To be Done | Prefix Sum |                                                                               |
| 3   | 561       | Completed  | -          | The larger one will be hidden, so using the second large to hide it.          |
| 4   | 66        | Completed  | Add        | [Note.add](https://github.com/rexbean/L/blob/master/Type/note.md#add)         |
| 5   | 122       | Completed  | Math       | profit = sumOf(sell - buy), when sell > buy                                                                              |
