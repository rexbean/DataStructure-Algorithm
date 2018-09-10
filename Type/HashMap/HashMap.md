# Hashmap
- [Summary](#Sumamry)
- [Applications](#Applications)

<h2 id = "applications">Applications</h2>

- Intersection(Exists or not)
-
<h3 id = "intersection">1. Intersection(Exists or not)</h3>

- **Use Set/Array (Time: O(n), Space:O(n))**

  1. String / Small difference integer ? array : HashSet
  2. Amounts equal ? HashMap : HashSet


  ```java
    // Exists or not?
    HashSet<<Element>> set = new HashSet<>();
    for(<Element> e : <first>){
        set.add(e);
    }
    for(<Element> e : <second>){
        if(set.contains(e)){
            // add to list
            result++;
        }
    }
    return result;

    // Exists in same amount
    HashMap<<Element>, Integer> map = new HashMap<>();
    for(<Element> e : <first>){
        map.put(e, map.getOrDefault(e, 0) + 1);
    }

    for(<Element> e : <second>){
        if(map.get(e) > 0){
            map.put(e, map.get(e) - 1);
            // add to list/set
            result++;
        }
    }
  ```
 | #   | # of prob | Status     | Type           | Note                                                                                                                                                                 |
| --- | --------- | ---------- | -------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | 771       | Completed  | HashSet        | [Note.intersection](#https://github.com/rexbean/L/blob/master/Type/note.md#intersection)                                                                             |
| 2   | 760       | Completed  | K-V(positions) |                                                                                                                                                                      |
| 3   | 359       | Completed  | K-V(time)      |                                                                                                                                                                      |
| 4   | 811       | Completed  | K-V(times)     | int index = 0;<br>while(index != -1){<br>&emsp;&emsp;s = s.indexOf(".");<br>&emsp;&emsp;s=s.substring(index + 1);<br>}</pre>                                         |
| 5   | 884       | Completed  | K-V(times)     | **ArrayList to Array**:<br> result.toArray(new String[result.size()]);                                                                                               |
| 6   | 500       | Completed  | K-V(position)  | trade of with switch-case                                                                                                                                            |
| 7   | 266       | Completed  | K-V(times)     |                                                                                                                                                                      |
| 8   | 463       | Completed  | K-V(times)     | HashMap is not always the best solution                                                                                                                              |
| 9   | 575       | Completed  | K-V(kinds)     | Using the number of keys                                                                                                                                             |
| 10  | 288       | Completed  | K-V(word)      | if two words in dict have same abb then<br> it is invalid                                                                                                            |
| 11  | 36        | To be Done | K-V(exists)    | trade off with hashSet                                                                                                                                               |
| 12  | 347       | To be Done | K-V(times)     | HashMap for times, Heap for k frequent.<br>Another solution is Bucket Sort<br>https://www.programcreek.com/<br>2014/05/leetcode-top-k-frequent-elements-java/        |
| 13  | 136       | Completed  | K-V(times)     | Haven't use times, set is better.<br> **bit operation(^)** is best for find the different number                                                                     |
| 14  | 1         | Completed  | K-V(position)  | **Two Sum**                                                                                                                                                          |
| 15  | 205       | Completed  | K-V(character) | Using two hash map can determine the relationship of one to one                                                                                                      |
| 16  | 299       | Completed  | K-V(character) | **1. When Using hashmap, think about what is unique, that should be the key.**<br>**2. can use another map to denote times**<br>**3. pay attention to the priority** |
