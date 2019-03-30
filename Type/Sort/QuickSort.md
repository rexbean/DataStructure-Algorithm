# Quick Sort
- [Definition](#definition)
- [Performance](#performance)
- [Implementation](#implementation)
- [Piviot Selection](#pivotSelection)
- [Analysis](#analysis)

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
    int pivot = nums[low];
    // 3,8,5,6,7,4,2,1
    int l = low ;
    int r = high;
    while(l < r){
        while(r > l && nums[r] >= pivot){
            r--;
        }

        while(l < r && nums[l] <= pivot){
            l++;
        }
        swap(nums, l, r);

    }
    swap(nums, l, low);
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
- first/last
- middle
- median of three

## <div id = "analysis">Analysis</div>
- Worst Case
- Best Case
- Average Case

## <div id = "optimizations">Optimizations</div>
