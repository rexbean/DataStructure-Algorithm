## 1 - 637 - easy
- if(root == null)
- Doing the addtion continuously may lead to out of bound exception.
    + long sum = 0;
    + double sum = 0;
- The average must be double. The division between two integer will be integer too.
    + double sum = 0;
    + average = (double) sum / size;

## 2 - 257 - easy
- Top - down parameters
    + result
    + subset
    + content (nums or root)
    + nums should also have startIndex
- Path is a path from root to leaf! Pay attention to the leaf nodes. If one node have either leftChild or righChild. It is not a leaf!

## 3 - 157 - easy
- First thing is analyze the condition the n will be. Is there any corner cases?
    + Common corner case
        + String == null
        + String.length == 0
        + s1.length == s2.length ==0
        + n < 0
        + n == 0
        +
## 4 - 653 - easy
- Two sum
    - hasmap
        - find whether target - nums[i] is in the map. In return true, not in put(target - nums[i],1)
    - two pointer
        - Should in a sorted array, if the sum of nums[start] & nums[end] == target return true, else if less than start++, if greater end--;
## 5 - 252 - easy
- Find the definition of the problem carefully.
- If the variables are more than one find a way to reduce variable(let it be under cotrol)
    - Arrays.sort()


        Arrays.sort(intervals, new Comparator<Intervals>(){
            public int compare(Interval v1, Interval v2){
                return v1.start - v2.start;
            }
        });

## 6 - 56 - medium
- A loop which adds previous things to result and deals with the next one.(Start value of the loop may be 1).In this way the last one won't be added into the result. Add it outside the loop, this can also solve when the length == 1

## 7 - 76 - hard
sliding window, firstly find all the elements meets the requirements, than move the left side to find all possibilities meet the reqirements.

## 8 - 283 - easy
when separate array into two parts with the original order. Do not use swap.just move!

## 9 - 133 - medium
- bfs of graph should have a set to judge whether the node has been visited.
- clone means all the things should be new.
- nodes do not mean only node, it has neighors.

## 10 - 554 - medium
prefixSum which appears the most times crosses the least bricks.
