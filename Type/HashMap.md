| #   | # of prob| Status     | Type            | Note                                                                                                                                                         |
| --- | ------------ | ---------- | --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 1   | 771          | Completed  | K-V(times)      | HashMap should have two generic type                                                                                                                         |
| 2   | 760          | Completed  | K-V(positions)  |                                                                                                                                                              |
| 3   | 359          | Completed  | K-V(time)       |                                                                                                                                                              |
| 4   | 811          | Completed  | K-V(times)      | int index = 0;<br>while(index != -1){<br>&emsp;&emsp;s = s.indexOf(".");<br>&emsp;&emsp;s=s.substring(index + 1);<br>}</pre>                                 |
| 5   | 884          | Completed  | K-V(times)      | **ArrayList to Array**:<br> result.toArray(new String[result.size()]);                                                                                       |
| 6   | 500          | Completed  | K-V(position)   | trade of with switch-case                                                                                                                                    |
| 7   | 266          | Completed  | K-V(times)      |                                                                                                                                                              |
| 8   | 463          | Completed  | K-V(times)      | HashMap is not always the best solution                                                                                                                      |
| 9   | 575          | Completed  | K-V(kinds)      | Using the number of keys                                                                                                                                     |
| 10  | 288          | Completed  | K-V(word)       | if two words in dict have same abb then<br> it is invalid                                                                                                    |
| 11  | 36           | To be Done | K-V(exists)     | trade off with hashSet                                                                                                                                       |
| 12  | 347          | To be Done | K-V(times)      | HashMap for times, Heap for k freqent.<br>Another solution is Bucket Sort<br>https://www.programcreek.com/<br>2014/05/leetcode-top-k-frequent-elements-java/ |
| 13  | 136          | Completed  | K-V(times)      | Haven't use times, set is better.<br> **bit operation(^)** is best for find the different number                                                             |
| 14  | 1            | Completed  | K-V(position)   | **Two Sum**                                                                                                                                                  |
| 15  | 3            | To be Done | Sliding Window |                                                                                                                                                              |
| 16  | 76           | Completed | Sliding Window | Find a window where a container contains all elements of other contianer:<br> 1. put all elements and times into a hash map.<br> 2. left = 0, right = 0, count = map.size()<br> 3. if an [right] in the map then map.get([right])- 1;<br> 4. if map.get([right]) == 0, count--;<br> which means the element [right] has been used out.<br> 5. right++; 6. while(count == 0) <br>which means, when all elements are in the window<br> 6. if [left] in is the map, map.put([left], map.get([left]) + 1);<br> 7. if map.get([left] > 0) count++;<br> which means<br> 8. do something with len<br> becare for len==0 which means it is the first one.                                                                                                                                                                |


# 76 Minimum Window Substring
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
