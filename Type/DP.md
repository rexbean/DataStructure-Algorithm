# Dynamic Programming

| # | # of Prob | Status | Type | Note |
| --|-----------|--------|------|------|
| 1 |746|Completed|1 | result\[i] = Math.min(result\[i - 1] + cost\[i - 1], result\[i - 2] + cost\[i - 2])         |
| 2 |256|To be Done | 1 | |
| 3 | 70 |Completed | 1 | result\[i] = result\[i - 1] + result\[i - 2]|
| 4 |198 |To be Done|interval||
| 5 |276| To be Done|interval||
| 6 |303|To be Done| prefix Sum|sum\[i,j] = sum\[j] - sum\[i]|
| 7 |338|Completed|Generate Number| dp\[i<<1] = dp\[i]; dp\[((i<<1) |1)] = dp\[i] + 1;|
| 8 |413|Completed|2->1|When 2 deminsion can be 1 demension|
## 1. Ugly Number
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
Given a number n, the task is to find n’th Ugly number.



``` Java
// Analysis:
// Array is for storing the value of ugly numbers
// The base case is 1
// Ugly[i] = Math.min(ugly2, Math.min(ugly3, ugly5));

int getNthUglyNo(int n)
{
	if(n <= 0){
	    return -1;
	}
	int[] result = new int[n];
	result[0] = 1;
	int i2 = 0, i3 = 0, i5 = 0;
	int ugly2 = 2, ugly3 = 3, ugly5 = 5;
	for(int index = 1; index < n; index++){
	    result[index] = Math.min(ugly2, Math.min(ugly3, ugly5));
	    if(result[index] == ugly2){
	        i2++;
	        ugly2 = result[i2] * 2;
	    }
	    if(result[index] == ugly3){
	        i3++;
	        ugly3 = result[i3] * 3;
	    }
	    if(result[index] == ugly5){
	        i5++;
	        ugly5 = result[i5] * 5;
	    }
	}
	return result[n - 1];
}

// 1. In the case of switch can just be static expression
// 2. The corner cases are that some of the products are equal, in that case, all of them should add 1;
```


## 2. Fibonacci Series

``` Java
// Analysis
// Array for the Fibonacci Series
// Base case: 1
// F[i] = F[i - 1] + F[i - 2]

static int fib(int n)
{
    int[] result = new int[n + 1];
      result[0] = 0;
      result[1] = 1;

      for(int i = 2; i <= n; i++){
          result[i] = result[i - 1] + result[i - 2];
      }

      return result[n];
}
```

## 3.
