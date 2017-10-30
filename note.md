## 1. loop
### if it can go into the loop
- 数学归纳法<br/>
    * the first one must be right<br/>
        + exits or not
        + right or not
- the end value is right or not
- the start value == end value?
- 如果递减 注意i-- 不是i++
### if it can not go into the loop
- check the value will be returned
### while loop
- check the while loop whether write i++ or not
- while loop's condition should be

        while(i < nums.length) not while(i!= nums.length -1 )
        this can avoid only one element in array.
- pay attention to some variables should initialize each turn
## 2. convert
- char to int
    + (int)(char) - 48 oen digit
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
- ### perfixSum



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
## 6. Binary Search
- ### Find the first one
- ### Find the last one


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
## 7. linked List
- while(current.next!= null)


        current.next ------> while(current != null)
        current.next.next ------> while(current.next!= null)
- 做一步是一步 做一步调整一下指针
- while using current.next.next what is the while condition?
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

- Mix
    + using top - down do the max / min
    + if using for edge, let null return -1;

## 9. Graph
### subset


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
- push()
    it means add
- pop()
    it means remove
- peek()
    it means return the top
- using for loop must get the size of stack first, in case it will be changed in the loop

## 19. Queue
- Queue<> queue = new LinkedList<>();
- offer()
    it means add
- poll()
    it means remove
- peek()
    it means get the top
- using for or while loop should get the size of stack first, in case it will be changed in the loop

## 20. Prime
- Sieve of Eratosthenes algorithm to find prime just
    + tag all coposite Numbers under n, the rest are primes

        - find all times of number from 2 to sqrt(n)
