# String
- [Summary](#summary)
- [Basic Knowledge](#basics)

## <h2 id = "summary">Summary</h2>
- Whether the input is case sensitive or not?

## <h2 id = "basics">Basic Knowledges</h2>
- Length: **String.length()**
- Equal : **String.equals()**
- Substring: **public String substring(int startIndex, int endIndex)**
  - StartIndex, inclusive
  - EndIndex, exclusive
- Split : **public String[] split(String pattern)**
  - it uses regex here, so **\*, \+, \.** should be used with "\\"
  - the result of the split the pattern itself:

  | String   | pattern | length | result   |
  | -------- | ------- | ------ | -------- |
  | e        | e       | 0      | “”       |
  | ee       | e       | 0      | ""       |
  | eeaebeee | e       | 3      | "", a, b |


| #   | # of Prob | Status     | Note                                                                                          |
| --- | --------- | ---------- | --------------------------------------------------------------------------------------------- |
| 1   | 681       | Completed  | Corner Case                                                                                   |
| 2   | 482       | Completed  | add separator before the Character                                                            |
| 3   | 686       | To be done | The method is too slow                                                                        |
| 4   | 14        | Completed  |                                                                                               |
| 5   | 415       | Completed  | Note.Add                                                                                      |
| 6   | 157       | Completed  | if renew the buf, the address of it will be changed                                           |
| 7   | 158       | Completed  | if the string is "" it maybe \u0000 not ""                                                    |
| 8   | 6         | Completed  | Analysis the rule clearly<br> corner case: s.length() < numRows                               |
| 9   | 12        | Completed  | Can use two array to replace TreeMap<br> Corner Case num >= e.getKey();<br> num -= e.getKey() |
| 10  | 151       | Completed  | String using equal to judge same or not                                                       |
| 11  | 65        | Completed  | Using loop to detect "." "e","+/-", digit                                                                                              |
