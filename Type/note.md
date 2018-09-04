## 1. int
- the division of two int will be int. If we want to get double, we just make one of the number to be double.
    + Using a double variable
      ``` Java
      double a;
      a/b
      ```
    + type casting
      ``` Java
      (double)a / b
      ```
## 2. Integer
- int is a primitive type, Integer is a class.
- Method
  - **Constructor**: new Integer(int) can instantiate a object of type Integer
  - **Integer.parseInt(String)** will return a int with the value of String
  - **Integer.valueOf(String)** will return a object of Integer, if the value is in the range of IntegerCache, it will return the same object, otherwise, it will return a new object.
- Comparartion between int and Integer
  - If one of the value is a int, it will be value comparation, just compare value
  - If both are Integer, it will be object comparation. If the value of the String is in the range of IntegerCache it will be equal, otherwise it will be different.
## 1. double

## 1. addition
- when we do the addition continuously, we should pay attention to the sum which will be out of bound.
    + Using long get the sum of the addition
    + If it is for the average, then we can let the sum to be double directly.

## 1. loop
### if it can go into the loop
- 数学归纳法<br/>
    * the first one must be right<br/>
        + exists or not
        + right or not
- the end value is right or not
- the start value == end value?
- 如果递减 注意i-- 不是i++
### if it can not go into the loop
- check the value will be returned
- A loop which adds previous things to result and deals with the next one.(Start value of the loop may be 1).In this way the last one won't be added into the result. Add it outside the loop, this can also solve when the length == 1
### while loop
- check the while loop whether write i++ or not
- while loop's condition should be

        while(i < nums.length) not while(i!= nums.length -1 )
        this can avoid only one element in array.
- pay attention to some variables should initialize each turn
## 2. convert
- char to int
    + (int)(char) - 48 one digit
- int to char
    + (char)(int + 48)
- char[] to String
    + String.valueof(char[])
- String to char[]
    + s.toCharArray();
## 3. 长度不一样的两个东西一起循环
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
        int aValue = (i >= 0) ? a.charAt(i) - '0' : 0;
        int bValue = (j >= 0) ? b.charAt(j) - '0' : 0;
        int sum = aValue + bValue + carry;
        ans = (sum % 2) + ans;
        carry = sum / 2;
    }
## 4. 进制转换
- 先取余数再求商
- ans = sum % 进制
- carry = sum / 进制
## 5. Array
- ### Arrays.sort()


        Arrays.sort(intervals, new Comparator<Intervals>(){
            public int compare(Interval v1, Interval v2){
                return v1.start - v2.start;
            }
        });
- ### perfixSum
    + Seldomly saving all prefixSum into an array.



        int maxSum = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(sum - minSum, maxSum);
            minSum = Math.min(sum, minSum);
        }
- ### the max difference
    - Only once

        this is like the prefixSum <br/>
        max difference = max(current - min)<br/>
        固定最右端，找前面最小的

    - Multipule times

        Find out all differences which are positive.

- ### two deminsional array
    + the length of each row nums[0].length
    + the number of rows nums.length
    + two matrix convert each other


            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    int rNums = (i * c + j) / numsColumns;
                    int cNums = (i * c + j) % numsColumns;
                    result[i][j] = nums[rNums][cNums];
                }
            }

- ### intervals
    + There are two variables, start and end. So we use sort to let one variable under control.
    + Overlap

            v1.start > v2.start && v2.start < v1.end
## 6. Binary Search
    int start = 0;
    int end = nums.length - 1;
    int mid = 0;
    while(start + 1 < end){
        mid = start + (end - start) / 2;
        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] < target){
            start = mid;
        } else {
            end = mid;
        }
    }
- ### Find the first one

        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
- ### Find the last one
        if(nums[end] == target){
            return end;
        }
        if(nums[start] == target){
            return start;
        }
        return -1;
- Sqrt(x)

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid == x / mid){
                return mid;
            } else if(mid <= x / mid){
                start = mid;
            } else {
                end = mid;
            }
        }
- rotated sorted Array
    + find the minimum

            int mid = 0;
            while(start + 1 < end){
                mid = start + (end - start) / 2;
                if(nums[mid] < nums[mid - 1]){
                    return mid;
                } else {
                    if(nums[mid] <= nums[nums.length - 1]){
                        end = mid;
                    } else {
                        start mid;
                    }
                }
            }
            if(nums[end] < nums[start]){
                return end;
            }
            return start;
    + search in rotated sorted Array

            int mid = 0;
            while(start + 1 < end){
                mid = start + (end - start) / 2;
                if(nums[start] < nums[mid]){
                    if(nums[start] <= target && target <= nums[mid]){
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    if(nums[mid] <= target && target <= nums[end]){
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
## 7. linked List
- while(current.next!= null)


        current.next ------> while(current != null)
        current.next.next ------> while(current.next!= null)
- 做一步是一步 做一步调整一下指针
- construct a new linked lists


    ListNode dummy = new ListNode(0);
    ListNode head = dummy;

    head.next = new ListNode(x);
    head = head.next;

    return dummy.next;

## 8. Tree
### predecessor
    if(root.left!=null){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
### successor
    if(root.right != null){
        root = right.left;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
### Leaf
- pay attention to deal with the leaves carefully.
### Path
- Path is a path from root to leaf! Pay attention to the leaf nodes. If one node have either leftChild or righChild. It is not a leaf!
### BFS
#### 层次遍历
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0; i < size; i++){
            TreeNode t = queue.poll();
            if(t.left != null){
                queue.offer(t.left);
            }
            if(t.right != null){
                queue.offer(t.right);
            }
        }
    }
### bottom - up / up - down
- Bottom - up
    + Divide & conquer
    + return a value from bottom or generate a node
- Top - down
    + add value each path
    + parameters
        + result
        + subset
        + content (nums or root)
        + nums should also have startIndex
- Mix
    + using top - down do the max / min
    + if using for edge, let null return -1;

## 9. Graph
### subset
- parameters: nums, start, subSet, result, (target)
- end condition: if(target == 0), if(# of elements == require)
- remove duplicate:
    + if(i != start && nums[i] == nums[i - 1]){
            continue;
    }

    + helper(nums, i + 1, subSet, result, (target));
- sum to tareget: in helper should be target - subSum
- for subset : subset.add(element) should in the first linked
- for permutation: it uses a set to check whether a number has been used
- DO NOT FORGET TO ADD RETURN IN THE END CONDITION


        private void helper(int num, int startIndex, ArrayList result, ArrayList subset){
            if(subset.size() == num){
                result.add(generateTime);
                return;
            }

            for(int i = startIndex; i < 10; i++){
                subset.add(i);
                helper(num, i + 1, result, subset);
                subset.remove(subset.size() - 1);
            }
        }
## 9. two pointers
### 相向two pointers
    while(start < end){
        while(start < end && !<not condition(start)>){
            start++;
        }
        while(start < end && !<not condition(end)>){
            end--;
        }
        swap(start,end);
        start++;
        end--;
    }
### 同向two pointers
    while(end < nums.length){
        if(nums[end] - nums[start] == k){
            start++;
            end++;
            while(start < nums.length && nums[start] == nums[start-1]){
                start++;
            }
            while(end < nums.length && nums[end] == nums[end - 1]){
                end++;
            }
        }
        if(start == end){
            end++;
        }
    }
- separate into two / three / several parts
    + separate into two parts

            while(right < nums.length){
                if(nums[right] != <condition>){
                    if(left != right){
                        int temp = nums[right];
                        nums[right] = nums[left];
                        nums[left] = temp;
                    }
                    left++;
                }
                right++;
            }
    + separate into three parts

            while(left < right){
                if(nums[left] == <leftCondition>){
                    swap(nums[left],nums[mid]);
                    left++;
                    mid++;
                } else if(nums[left] == <midCondition>){
                    left++;
                } else {
                    swap(nums[right],nums[left]);
                    right--;
                }
            }
### fast and slow pointer
### 三步翻转法 （循环操作要想到）
- 向右循环 (0, len - k - 1) (len - k, len - 1)(0, len - 1)
- 向左循环 (0, k - 1)(k, len - 1)(0, len - 1)


        int k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        void reverse(int[] nums, int start, int end){
            while(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
## 10. remove duplicate or skip some elements
- remove duplicate should use while loop

## 11. String and Character
- Corner case:
    + If two inputs are both String. Check both of them's lenght are 0, are null, either is 0, either is null.

- String can be merged by "+"


- Uppercase or lowercase of a String


        s = s.toUpperCase()
        s = s.toLowerCase()

- Find out whether a character is Letter or Digit


        Character.isLetter(c)
        Character.isDigit(c)

- Get the ith char of a String


        s.charAt(i)

- Char Array to String


        s.toCharArray()
        String.valueOf(c[])

- String.replace() replaceAll() replaceFirst()
    + replace() replace all the character which you want to replace
    + replaceAll() using Regex replace all characters which match the regex
    + replaceFirst() using Regex replace the first one which matchs the regex

- String.split has also used regex
- Collections.reverse() does not have return value;

## 12. Integer
### Integer & Binary String
- Integer.toBinaryString
    get the String of int in bianary
- Integer.parseInt(s,"2");
    parse the Binary String to int
## 13. Bit operations
- Using for loop

    for(int i = 0; i < 32; i++){

    }
- & is used to get binary digit
- |1 is used to set binary digit 1
- ~ reverse all bits
- ^ (exclusive or |XOR)
- \>> move right add the sign bit at head
- << move left add 0 at end
- \>>> move right add 0 at head
- do not use temp to swap two int

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
- to see whether a int is power of 2

        return (n & (n-1)) == 0
- to see whether a int is odd or even

        return (n & 1) == 0

- *2 or /2  or * power of 2 or / power of 2

        *2   x << 1
        /2   x >> 1
        *2^n x << n
        /2^n x >> n
- to see whether have same sign

        return (x^y)>=0 (same sign)




## 14. bash script

## 15. Regex

## 16. fast and slow pointer

## 17. HashMap
- Using hashmap can check whether the element is in or not and set is index.
- Using hashmap can check duplicate.
- traversal hashmap

        for(int i: map.keySet()){
            a += map.get(i);
        }

- Using two hashmap can check whether the elements are one on one


        if(sMap.containsKey(cs) && sMap.get(cs) != ct){
            return false;
        } else {
            sMap.put(cs,ct);
        }
        if(tMap.containsKey(ct) && tMap.get(ct) != cs){
            return false;
        } else {
            tMap.put(ct,cs);
        }

        if(sMap.get(cs) == tMap.get(ct)){
            continue;
        } else {
            return false;
        }

## 18. Stack
- Java doesn't have the Interface of Stack. it just has a class named Stack(Java.util.Stack), it is extended by Vector. This implementation is synchronous ans slow. It will always be implemented by **ArrayDeque** or **LinkedList**
- **Constructor**
  ``` Java
  Deque<> stack = new ArrayDeque<>();  // when it always insert or delete the head or tail
  Deque<> stack = new LinkedList<>(); // when it always insert or delete the value in the middle
  ```
- **Method**
  - *push()*
    it means add
  - *pop()*
    it means remove
  - *peek()*
    it means return the top
  - *equals()* It can directly compare all values of two stacks whether equal or not
- **Caution**
  - When using pop, it must be assured that the stack is not empty!
  - using for loop must get the size of stack first, in case it will be changed in the loop
- **Usage**
  - **Using stack, when it will do nothing just push the value into the stack util a particular condition happens**
    - **General**: Some characters are triggers
    - **Monotone**: The value is not obey the monotone as before.

## 19. Queue
- **Constructor**
  ```Java
  Queue<> queue = new LinkedList<>();
  ```
- **Method**
  - *offer()* It has the same functionality as *add()*. But *add()* will return **uncheck Exception** when the stack is full. *offer()* will return false
  - *poll()* It has the same functionality as *remove()*. But *remove()* will throw exception when the stack is empty, *poll()* will return null
  - *peek()* It has the same functionality as *element()*. But *element()* will throw exception when the queue is empty, *peek()* will return null
- using for or while loop should get the size of stack first, in case it will be changed in the loop

## 20. Prime
- Sieve of Eratosthenes algorithm to find prime just
    + tag all coposite Numbers under n, the rest are primes

        - find all times of number from 2 to sqrt(n)

## hamming distance
- total hamming distance += number of 1s * number of 0s every digit


    for(int i = 0; i < nums.length; i++){
        for(int j = 31; j >=0 ; j--){
            distance[j] += (nums[i] & 1);   // here could be nums[i] % 2
            nums[i] >>= 1;    //here could be nums[i] /= 2;
        }
    }
    for(int i = 0; i < 31; i++){
        result += distance[i] * (nums.length - distance[i]);
    }
    return result;
## <h2 id = "merge">Merge</h2>
### merge two Intervals
    if(i1.start <= i2.start){
        if(i2.start <= i1.end){
            int end = Math.max(i1.end, i2.end);
            Interval i = new Interval(i1.start,end);
        } else {
            Interval i1;
            Interval i2;
        }
    } else {
        if(i1.start <= i2.end){
            int end = Math.max(i1.end, i2.end);
            Interval i = new Interval(i2.start, end);
        } else {
            Interval i2;
            Interval i1;
        }
    }

## merge two sorted arrays / lists / intervals
    int i = 0;  // the pointer of first data structure;
    int j = 0;  // the pointer of second data structure;
    int k = 0;  // the pointer of the result data structure;
    while(i < A.size() && j < B.size()){
        if(A[i] < B[j]){
            // add(A[i]);
            // k++;
            // i++;
        } else {
            // add(B[j]);
            // k++;
            // j++;
        }
    }
    while(i != A.size()){
        // add(A[i]);
        // k++;
        // i++;
    }
    while(j != B.size()){
        // add(B[j]);
        // k++;
        // j++;
    }

## merge k sorted array / lists / Intervals(Using priorityQueue)
  ``` Java
  if(lists == null || lists.length == 0){
      return null;
  }

  Queue<ListNode> heap = new PriorityQueue<>(lists.length, (node1, node2) -> node1.val - node2.val); // for interval, here will be i1.start - i2.start;

  ListNode dummy = new ListNode(0);
  ListNode cur = dummy;

  for(ListNode l : lists){
      if(l != null){
          heap.offer(l);
      }

  }

  while(!heap.isEmpty()){
      ListNode temp = heap.poll();
      cur.next = new ListNode(temp.val);
      cur = cur.next;
      if(temp.next != null){
          heap.offer(temp.next);
      }
      //Interval t = heap.poll();
      // if(t.start <= last.end){
      //     last.end = Math.max(last.end, t.end);
      // } else {
      //     result.add(last);
      //     last = t;
      //}
  }
  return dummy.next;

  ```
## Sliding window
- sliding window template: https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
- sliding window may use queue to be a break point
- the condition that left pointer ++;
    1. all letters existed and the times are correct
        using one count to represent this.
    2. Using map.get() == 1 to represent appearing, using map.get() == 0 represents not appearing
    3. k distinct characters, count represents the number of distinct letters
- template

        // corner case
        <!-- HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: s){
            map.put(c, map.getOrDefault(c, 0) + 1);
        } -->

        int left = 0;
        int right = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;

        while(right < p.length()){
            char c = p.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1){
                count++;
            }
            right++;

            while(count > k){
                char cTemp = p.charAt(left);
                if(map.containsKey(cTemp)){
                    map.put(cTemp, map.get(cTemp) - 1);
                }
                if(map.get(cTemp) == 0){
                    count--;
                }
                left++;
            }
        }
        len = Math.max(len, right - left);
## <h2 id = "add">Add</h2>
  ``` Java
  while(num1 != end || num2 != end){
      int first = num1[i].exists() ? num1[i] : 0;
      int sec = nums2[i].exists() ? num2[i] : 0;

      int sum = first + sec + carry;
      carry = 0;
      if(sum > 9){
          carry = 1;
          sum = sum % 10;
      }
      new[index] = sum;
      index++;
      if(num1[i].exists()){
          num1 = num1.next;
      }
      if(num2[i].exists()){
          num2 = num2.next;
      }
  }
  if(carry != 0){
      new[index] = carry;
  }
  ```
