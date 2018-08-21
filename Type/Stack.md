# Stack
| #   | # problem | Status    | Type                 | Note                                         |
| --- | --------- | --------- | -------------------- | -------------------------------------------- |
| 1   | 682       | Completed | General              | note.Integer                                 |
| 2   | 496       | Completed | Monotone Stack       | hashmap or array                             |
| 3   | 844       | Completed | General, Two Pointer | StringBuilder, StringBuffer                  |
| 4   | 232       | Completed | General              | !!Important                                  |
| 5   | 20        | Completed | General              | if(stack.isEmpty()  \|\| stack.pop() != '[') **return false**; |
|     |           |           |                      |                                              |
|     |           |           |                      |                                              |





## 1. Baseball Game
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

``` Java
public int calPoints(String[] ops) {
    if(ops == null || ops.length == 0){
        return 0;
    }

    int result = 0;
    Deque<Integer> stack = new LinkedList<>();

    for(String s : ops){
        int temp = 0;
        if(s.equals("C") && !stack.isEmpty()){
            result -= stack.pop();
        } else if(s.equals("D") && !stack.isEmpty()){
            temp = stack.peek() * 2;
            result += temp;
            stack.push(temp);
        } else if(s.equals("+") && !stack.isEmpty()){
            temp = stack.pop();
            if(!stack.isEmpty()){
                int secFromLast = stack.peek();
                result += temp + secFromLast;
                stack.push(temp);
                stack.push(temp + secFromLast);
            }
        } else {
            temp = Integer.parseInt(s);
            result += temp;
            stack.push(temp);
        }
    }
    return result;
}
```
