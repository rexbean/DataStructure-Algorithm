# Google
## 1. Space Ship (Dynamic Programming)
You have a spaceship parking at an orbit that is x (x > 0) light-minute away from the earth. The spaceship is able to fly in three modes in each minute: forward drifting in the speed of light (x += 1), backward drifting in the speed of light (x -= 1) and hyperspace leap (x *= 2).

Now you have an urgent task to travel to a planet that is n light-minutes (n > 0) away from the earth. In order to save time, you need to write a program to calculate the minimum minutes m to travel to the planet using your spaceship. Your program also needs to print out the travel path. Because n is a gigantic number, the time and space complexity of the program must both be O(n) or better.

Example input: n=15 x=1

Example output: m=5 x=x+1=2. x=x\*2=4 x=x\*2=8 x=x\*2=16. x=x-1=15

``` Java
class Solution{
  public int computeSteps(int x, int n){
      int[] array = new int[n  - x + 3];

      for(int i = 0; i < n + 2;i++){
          array[i] = Integer.MAX_VALUE;
      }
      array[1] = 0;
      for(int i = x; i < n + 2; i++){
          int index = i - x + 1;
          if(index >= 0){
              array[index - 1] = Math.min(array[index - 1], array[index] + 1);
          }
          if(index + 1 <= n - x + 2){
              array[index + 1] = Math.min(array[index + 1], array[index] + 1);
          }
          if(index * 2 <= n - x + 2){
              array[index * 2] = Math.min(array[index * 2], array[index] + 1);
          }

      }
      return array[n - x + 1];
  }
}
```
## 2. minimum distance between two nodes(Tree)
给一个tree, 给定两个node，求两个node之间最小的距离（edge数）是多少。.
最后分析一下算法的时间空间复杂度。


## 3.手牌
- http://www.1point3acres.com/bbs/thread-440590-1-1.html
- 一幅长度为n的手牌，用array表示，牌的点数没有大小限制，重复次数也没有限制。求是否可以分解成五张相同的牌的组合。
follow up：
同一幅手牌，求是否可以分解成长度为五的顺子的组合
同一幅，求是否可以分解成长度>=3的顺子的组合

## 4. Candy Crush
- http://www.1point3acres.com/bbs/thread-440590-1-1.html
- Generate candycrush game board. 输入是dimension和set of colors to choose from
follow up:
如何确保游戏一定可以进行至少一轮？（一定有至少一个swap可以消掉糖果）

## 5. 数列
- http://www.1point3acres.com/bbs/thread-440590-1-1.html
- 有一个数列，包含一天内一个人的所有commitid，按时间顺序排序。
提供一个testAPI，返回 commit id下的code是否有error
求一天内最早出现error的commitid
二分法，需要先做assumption：如果一个时间点没有error，可以assume之前的commit都没有error，recursionon 后半段。如果一个点有error，可以assume之后的点都有error，recursion on 前半段
follow up：
给定长度为n的数列，最少进行多少次比较可以求出min和max（3/2n-2）

## 6. n-arytree，
- http://www.1point3acres.com/bbs/thread-440590-1-1.html
- n-arytree, 自定义node结构，求和
follow up：
给定一个array，包含所有n-arytree node，找出root （hashset）
求kth element（quickselect）

## 7. doubly linkedlist
- remove first element of the target key from doubly linked list
例如 1<->2<->3<->2 target key 是2，结果1<->3<->2

## 8. 环形ListNode，
- 环形ListNode, 隔一个删一个
例如 1->2->3->1 结果 1->3->1 （这里的两个1 是同一个node）.留学论坛-一亩-三分地
1->2->3->4->1 结果1->3->1
