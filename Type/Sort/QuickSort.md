# Quick Sort
- [Definition](#definition)
- [Implementation](#implementation)
- [Piviot Selection](#pivotSelection)
- [Analysis](#analysis)
- [Optimizations](#optimizations)
- [Quick Selection](#quickSelect)

## <div id = "definition">Definition</div>
- Quick sort is same as the merge sort using Divide and Conquer.
- Soring is done in the divide part but nothing in conquer part.

## <div id = "implementation">Implementation</div>
``` java
public static void quickSort(int[] nums, int low, int high){
    if(low >= high){
        return;
    }
    int index = partition2(nums, low, high);
    quickSort(nums, low, index - 1);
    quickSort(nums, index + 1, high);
}

// partition One
public static int partition1(int[] nums, int low, int high){
    int pivot = nums[low];
    int l = low + 1;

    for(int i = low + 1; i <= high; i++){
        if(nums[i] < pivot){
            swap(nums,l, i);
            l++;
        }
    }
    swap(nums, l - 1, low);

    return l - 1;
}


public static int partition2(int[] nums, int low, int high){
    // random can make it faster!!!
    Random random = new Random();
    int p = left + random.nextInt(high - low);
    swap(nums, left, p);
    int pivot = nums[left];
    // 3,8,5,6,7,4,2,1
    int l = low ;
    int r = high;
    while(l < r){
        while(l < r && nums[r] >= pivot){
            r--;
        }

        nums[l] = nums[r];
        while(l < r && nums[l] < pivot){
            l++;
        }
        nums[r] = nums[l];
    }
    nums[l] = pivot;
    return l;
}

public static void swap(int[] nums, int i, int j){
    if(i > nums.length || j > nums.length || i < 0 || j < 0){
        return;
    }

    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```
## <div id = "pivotSelection">Pivot selection</div>
### First/Last/Middle
- If the numbers in the array are disordered and using the number in one of these three position as pivot, the time complexity is acceptable.
- When the array is ordered or patially ordered, the time complexity will become worse, even worst(O(n^2)).
### Random index
- If we use the number in random position as pivot each time, we won't get the worst case everytime.
- But when the numbers in array are all equal. It will result in the worst case(O(n^2)). But it only has 1/(2^n) probability to get into this situation.
### Median of three
- The best partition is that the length of two parts are equal. If the median of the array can be got, the best partition can be reached, but it will cost a lot of time. This can be replaced by computing the median of three number picked up randomly from the array

## <div id = "analysis">Analysis</div>
### Worst Case
- When the array is oredered or the numbers in it are equal -- O(n^2)
### Best Case
- The length of the two parts after partition are equal -- O(n^2)
### Average Case
- Randomly pick up a number as pivot each time, But will have 1/(2^n) probability to get the worst case, when the numbers in the array are equal -- O(nlog(n))

## <div id = "optimizations">Optimizations</div>
### Using insertion sort when the number of array is small
When the length of the array/subarray is less than a threshold, quick sort can be replaced by insetion sort. Because quick sort has big overhead. Recursion will create a lot of stack frames.
### Using 3-way partition
- When partitioning the array, 3-way partition divide the array into three parts. less, equal and larger. The first and third parts will be sorted.
```java
private void threewayPartition(int[] A, int left, int right){
    if(left >= right){
        return;
    }

    int pivot = A[left];
    int l = left;
    int r = right;

    int m = l;

    while(m <= r){
        if(A[m] > pivot){
            swap(A, m, r);
            r--;
        } else if(A[m] < pivot){
            swap(A, l, m);
            l++;
            m++;
        } else {
            m++;
        }
    }
    threewayPartition(A, left, l - 1);
    threewayPartition(A, r + 1, right);
}
```
### Using Dual pivot quick sort
- In Java, `Arrays.sort()` using `DualPivotQuickSort`. When the length of the array is less than the threshold `47` as default, it will use `insertionSort` otherwise `DualPivotQuickSort` will be used
- `DualPivotQuickSort` will use two pivot, one is the left, the other one is the right. The first pivot must smaller than the second one, which means swap operation may be needed.
```java
private void dualPivotQuickSort(int[] A, int left, int right){
        if(left >= right){
            return;
        }

        if(A[left] > A[right]){
            swap(A, left, right);
        }

        int p1 = A[left];
        int p2 = A[right];

        int l = left + 1;
        int m = left + 1;
        int r = right - 1;

        while(m <= r){
            if(A[m] > p2){
                swap(A, m, r);
                r--;
            } else if(A[m] < p1){
                swap(A, m, l);
                l++;
                m++;
            } else {
                m++;
            }
        }
        swap(A, left, l - 1);
        swap(A, right, r + 1);

        dualPivotQuickSort(A, left, l - 2);
        dualPivotQuickSort(A, l, r);
        dualPivotQuickSort(A, r + 2, right);
    }
```
## <h2 id = "quickSelect">Quick Selection</h2>
Using `partition` algorithm of the quick sort can select the k-th element in the collection
```java
public int quickSelect(int[] nums, int k){
    if(nums == null || nums.length == 0){
        return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while(left <= right){
        int index = partition(nums, left, right);
        if(index < k){
            index = partition(nums, index + 1, right);
        } else if(index > k){
            index = partition(nums, left, index - 1);
        } else {
            return nums[index];
        }
    }
}
```
