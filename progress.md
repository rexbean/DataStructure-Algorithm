## 1 - 10/27 - 1 - 53.
### read the greedy algorithm
### prefixSum

    int maxSum = Integer.MIN_VALUE;
    int minSum = 0;
    int sum = 0;
    for(int i = 0; i < nums.length; i++){
        sum += nums[i];
        maxSum = Math.max(sum - minSum, maxSum);
        minSum = Math.min(sum, minSum);
    }
## 2 - 10/27 - 2 - 58.
- find out the definition clearly
- check loop
## 3 - 10/27 - 3 - 66.
- pay attention to the i--
- better solution from jiuzhang
    + once the carry is 0, it can break;
    + new array can delcare when it is needed.
## 4 - 10/27 - 4 - 67
- 1 + 1 + 1 =3
- pay attention to the start value = 1
- can use s.charAt()
- ans = sum % 2
- carry = sum / 2
- String可以用 “+” 拼接
### 长度不一样的两个东西一起循环
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aValue = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bValue = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = aValue + bValue + carry;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
## 5 - 10/27 - 5 - 69
### binary search
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
### maybe should use long type
## 6 - 10/27 - 6 - 83
### 思维又怪异了?
### remember to do the current = current.next;
    while(current != null){
        if(prev.val == current.val){
            prev.next = current.next;
        } else {
            prev = current;
        }
        current = current.next;
    }
## 7 - 10/27 - 7 - 88
### 不等长计算循环
    while(m > 0 || n > 0){
        int a = m - 1 >= 0 ? nums1[m - 1] : Integer.MIN_VALUE;
        int b = n - 1 >= 0 ? nums2[n - 1] : Integer.MIN_VALUE;
        if(a >= b){
            nums1[m + n - 1] = a;
            m--;
        } else {
            nums1[m + n - 1] = b;
            n--;
        }
    }

## 8 - 10/27 - 8 - 107
### Collections.reverse()不一定就不好
### 层次BFS
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
## 9 - 10/27 - 9 - 108
### Tree
- Bottom - up
    + return a value from bottom or generate a node
- Top - down
    + add value each path
## 10 - 10/27 - 10 - 118
## 11 - 10/27 - 11 - 121
- It is like maximum subArray.
- max differece = max (current - min)
## 12 - 10/27 - 12 - 122
- 并没有理解到问题的本质 应该多举例子 make the right definition
- follow up 不一定延续前一问 的思路
## 13 - 10/27 - 13 - 125
- alphanumeric 文字数字的
- s = s.toUpperCase();
- s = s.toLowerCase();
- Character.isLetter(c);
- Character.isDigit(c);
- while loop must write i++ by yourself
### 同向指针 while loop condition


    while(start < end)
## 14 - 10/27 - 14 - 141
### LinkedList using a.next.next while loop condition

## 15 - 10/27 - 15 - 168
- find out the definition first!
- Think about the recursion for this problem

## 16 - 10/27 - 16 - 169
majority
- need more time to think about O(n) & O(1)

## 17 - 10/27 - 17 - 171
- 进制转换

## 18 - 10/27 - 18 - 189
- 三步翻转法 （循环操作要想到）


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
## 19 - 10/28 - 1 - 191
### Integer to binary String
    Integer.toBinaryString(n);
### BinaryString to Intger
    Integer.parseInt(s,"2");

## 20 - 10/28 - 2 - 217
Time of using hashset to check duplicate is too long
Using HashMap to check duplicate.

## 21 - 10/28 - 3 - 219
Find the definition clearly.
At most means the minimum should less than.

## 22 - 10/28 - 4 - 231
- when mention power of 2,think about the bit operation
- power of 2 are all even!

## 23 - 10/28 - 5 - 349
while(i < nums.length) not while(i != nums.length -1)
this can avoid only one element in array.

## 24 - 10/28 - 6 - 350
- 不懂九章解法

## 25 - 10/28 - 7 - 345

## 26 - 10/28 - 8 - 342
whether a number is power of 4 it should be positive

## 27 - 10/28 - 9 - 242
- traversal hashmap


    for(int i: map.keySet()){
        a += map.get(i);
    }

## 28 - 10/28 - 10 - 94

## 29 - 10/28 - 11 - 102

## 30 - 10/28 - 12 - 103
Collections.reverse(ArrayList) does not have return value;

## 31 - 10/28 - 13 - 14

## 32 - 10/28 - 14 - 190
- & to get bit
- | to set bit

## 33 - 10/28 - 15 - 202
- find out what is happy number, what is not happy number. What the feature is not the happy number
- while loop need to pay attention to initiliaze each turn

## 34 - 10/28 - 16 - 204
- Sieve of Eratosthenes algorithm to find prime just
    + tag all coposite Numbers under n, the rest are primes

        - find all times of number from 2 to sqrt(n)

## 35 - 10/28 - 17 - 205
- Isomorphic 同构
- using hashmap to check whether elements are one on one

## 36 - 10/28 - 18 - 206
- LinkedList usually uses two pointer prev and current;
- LinkedList usually uses dummy node. dummy.next = head

## 37 - 10/28 - 19 - 278
- Binary Search
- find the first one
- if(isBadVersion(start))
- if(isBadVersion(end))

## 38 - 10/28 - 20 - 290

## 39 - 10/29 - 1 - 374
read the problem carefully, find out the definition clearly.

## 40 - 10/29 - 2 - 383
if input are two strings. Check both of them's length are 0. either is 0

## 41 - 10/29 - 3 - 387
- Hashmap only can solve whether an element has appeared or not and its index.
- find output first

## 42 - 10/29 - 4 - 401
- Subset
- Recursion all the possibles


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
## 43 - 10/29 - 5 - 566
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            int rNums = (i * c + j) / numsColumns;
            int cNums = (i * c + j) % numsColumns;
            result[i][j] = nums[rNums][cNums];
        }
    }

## 44 - 10/29 - 6 - 561

## 45 - 10/29 - 7 - 551
read the problem carefully

## 46 - 10/29 - 8 - 543
- when max / min value should use top down
- when related to path, let null return -1

## 47 - 10/29 - 9 - 541

## 48 - 10/29 - 10 - 532
- two pointer in the same direction

## 49 - 10/29 - 11 - 530
- the predecessor and the successor of the tree.

## 50 - 10/29 - 12 - 496

## 51 - 10/29 - 13 - 409
palindrome

## 52 - 11/1 - 1 - 443

## 53 - 11/17 - 1 - 19
two pointer from one side and with the certain difference between them.

## 54 - 11/17 - 2 - 22
The question about subset
when need to substract after the helper function
The difference with String+= & String+

## 55 - 11/17 - 3 - 11
Two pointer
volume = (right - left) * Math.min(nums[right],nums[left])
The biggest value of right - left is the first one and the last one. It has the highest possiblity get the result. So using two pointers to hold the variable(right - left).
- Think about how to deal with the duplicate. This just use one height so just move one ponter to remove the duplicate

## 56 - 11/17 - 4 - 3
This is a sliding window problem.Sliding window should be a separate topic.
a wonderful summary of using sliding window in leetcode
https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem

https://medium.com/@dvng13/sliding-window-algorithm-377bebd7b57

## 57 - 11/18 - 1 - 654
divide and conquer

## 58 - 11/18 - 2 - 643
prefixSum with sliding window
-  prefixSum should do something with sum we should use method like slidin window
-  prefixSum should do something with times or whether appear or not using HashMap
    + times of subarray equals k
    + maximum subarray equals k
## 59 - 11/18 - 3 - 697
- 固定一端，另一端通过for循环进行变化，每次计算出当前的最大值 一次进行这样可以再O(n)完成操作
- Using two maps instead of one map with a Array;
## 60 - 11/19 - 1 - 581

## 61 - 11/19 - 2 - 713
- two pointer should have the condition left< right || left <= right

## 62 - 11/19 - 3 - 209
- two pointer sliding window

## 63 - 11/19 - 4 - 152
- the corner case of the product is Zero
- Using prefixProduct like prefixSum
## 64 - 11/19 - 5 - 523
- the corner case of the remain is Zero
- if a % c == b % c then (a - b) % c = 0
- think about the 0

## 65 - 11/19 - 6 - 153
the last element is the important one.

## 66 - 11/19 - 7 - 228

## 67 - 11/19 - 8 - 258

## 68 - 11/19 - 9 - 554
prefixSum

## 69 - 11/19 - 10 - 657

## 70 - 11/19 - 11 - 728

## 71 - 11/20 - 1 - 133

## 72 - 11/20 - 2 - 382
Reservoir sampling

## 73 - 11/21 - 1 - 130
BFS

## 74 - 11/21 - 2 - 199
BFS

## 75 - 11/21 - 3 - 242
Anagram using hashmap

## 76 - 11/21 - 4 - 438
sliding window

## 77 - 11/22 - 5 - 49
Anagram

## 78 - 11/22 - 6 - 130
BFS

## 79 - 11/23 - 1 - 513

## 80 - 11/23 - 2 - 417

## 81 - 11/23 - 3 - 542

## 82 - 11/23 - 4 - 515

## 83 - 11/23 - 5 - 16
like 3 sum

## 84 - 11/23 - 6 - 18
4 sum
- if(i != 0 && nums[i] != nums[i - 1]) // remove duplicate 1
- while(left < right && nums[left] != nums[left - 1])
- while(left < right && nums[right] != nums[right +1])
//remove duplicate 2

## 86 - 11/23 - 7 - 61
- rotated list is a cycle so it should compute the length at first and rotate length % length;
- fast & slow pointer

## 87 - 11/23 - 8 - 142
fast and slow pointer

## 88 - 11/24 - 1 - 463
## 89 - 11/24 - 2 - 46
permutation
## 90 - 11/24 - 3 - 39
subset
## 91 - 11/24 - 4 - 40
- remove duplicate: if(i != start && nums[i] == nums[i - 1]){
continue;
} // this can be only used when the array is sorted
- every number using once:
  helper(nums, i + 1, subset, result);
## 92 - 11/24  - 5 - 77
helper(nums, i + 1, subset, result); // not start + 1 here

## 93 - 11/24 - 6 - 93
- i < start + 3 // maximum size of each part
- if(s.charAt(0) == '0'){
    return s.equals("0");
}
- if(sublist.size() == 4){
    if(start != s.length()){
        return;
    }
}

## 94 - 11/24 - 7 - 4
- how to create a new linkedList
- carry must set to 0 after using it;

## 95 - 12/13 - 1 - 482
- maybe do the operation to string reverse will be a good result;
## 96 - 12/13 - 2 - 346
- sliding window may use queue to be a breakpoint

## 97 - 12/13 - 3 - 298
- finding max value in tree must use a datamember to store the maxvalue;
