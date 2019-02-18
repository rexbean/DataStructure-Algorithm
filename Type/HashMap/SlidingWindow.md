# Slidng Window
- [Summary](#summary)
- [Reference](#reference)
<h2 id = "summary">Summary</h2>

- **Caution!!!**
  - Sliding Window can not be used on the problem of sum of subarray!!!! Because if there is an negative integer, the left moving condition will false.

- Procedure
  - Think about what the count represents for and the first value of it.
  - Think about when the count will change.
  - Think about the condition that left pointer should move

- If the element is a char or a integer, array can be used instead of the hashmap.
- Type
  - <div id = "existing">Existing</div>
  
    - count: the number of element' type which does not in the window
    - count = map.size();
    - when map.get(element == 0) ==> count --;
    - when count == 0, left pointer move
    - when map.get(element > 0) ==> count ++;
  - <div id ="interval">Interval</div>
- Template
```Java
  //Initialize an array or a hash map
  int left = 0;
  int right = 0;
  int count = 0 // count may be the map size in existing problem
  int result = 0;
  while(right < length){ // length is the length of the array or the string
      e = the element that the right pointer points to;
      // change the times of a here
      // judge whether a times meets some condition that count should change
      right++;

      while(left pointer moving condition){
          t = the element that the left pointer points to;
          // change the times of t here
          // judge whether count meets the condition
          // compute length here!!!
          // here can get the minimum length of the window
          left++;
      }
      // compute length here!!!
      // the length here is the maximum length before shrinking.
  }
  return result;
```
<h2 id = "reference">Reference</h2>

-  https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem



| #   | # of Prob | Status     | Note                                                                                                                                                      |
| --- | --------- | ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 15  | 3         | Completed  | **No duplicate Elements in window**<br> 1. Using 1 to represent in, using 0 to represent not in.                                                          |
| 16  | 76        | Completed  | [Existing](#existing)                                                                                                                                     |
| 17  | 30        | To be Done |                                                                                                                                                           |
| 18  | 340       | Completed  | same idea as 159                                                                                                                                          |
| 19  | 159       | Completed  | 2. left increasing condition: count > 2<br> 3. count increasing condition: array[[right]] == 1 |
| 20  | 567       | Completed  |                                                                                                                                                           |
| 21  | 438       | Completed | same idea as 76                                                                                                                                           |



## 76 Minimum Window Substring
```Java
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = map.size();
        int len = 0;
        int index = 0;
        while(right < s.length()){
            char c = s.charAt(right);

            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    count--;
                }
            }
            right++;

            while(count == 0){
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0){
                        count++;
                    }
                }
                if(len == 0 || len > right - left){
                    len = right - left;
                    index = left;
                }
                left++;
            }
        }
        return s.substring(index, index + len);
    }
}

```
    |           |        |      |
