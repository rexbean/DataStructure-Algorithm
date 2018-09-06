# Slidng Window
- [Summary](#summary)

<h2 id = "summary">Summary</h2>

- Sliding Window can not be used on the problem of sum of subarray!!!! Because if there is an negative integer, the left moving condition will false.

- Procedure
  - Think about what the count represents for and the first value of it.
  - Think about when the count will increase.
  - Think about the condition that left pointer should move

- If the element is a char or a integer, array can be used instead of the hashmap.
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




| #   | # of Prob | Status | Note |
| --- | --------- | ------ | ---- |
| 15  | 3            | Completed | **No duplicate Elements in window**<br> 1. Using 1 to represent in, using 0 to represent not in.                                                                                                                                                              |
| 16  | 76           | Completed | Find a window where a container contains all elements of other container:<br> 1. put all elements and times into a hash map.<br> 2. left = 0, right = 0, count = map.size()<br> 3. if an [right] in the map then map.get([right])- 1;<br> 4. if map.get([right]) == 0, count--;<br> which means the element [right] has been used out.<br> 5. right++; 6. while(count == 0) <br>which means, when all elements are in the window<br> 6. if [left] in is the map, map.put([left], map.get([left]) + 1);<br> 7. if map.get([left] > 0) count++;<br> The number of elements in or out each time will be **1**<br>which means the maximum value is **1**<br>So when the map.get([left] > 0), count can be increased<br> 8. do something with len<br> be careful when len==0 which means it is the first one.                                                                                                                                                                |
| 17 | 30| To be Done| |
| 18 | 340| Completed| same idea as 159|
| 19 | 159| Completed | 1. if it is a string, using an array with length of 256<br>2. left increasing condition: count > 2<br> 3. count increasing condition: array[[right]] == 1|
| 20 | 567| Completed | |
| 21 | 438| To be Done | same idea as 76|


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
