package yi.sort;

import java.util.Arrays;

public class CountingSort {
    //什么时候用计数排序呢

    /**
     * sort 
     * 1. 获取最大值
     * 2. 计数排序
     */
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }
    
    /**
     * getMaxValue
     */
    private int getMaxValue(int[] arr){
        int maxValue = arr[0];
        for(int value: arr){
            if (maxValue < value) maxValue = value;
        }
        return maxValue;
    }
    /**
     * CountingSort
     * bucket,bucketlen
     */
    private int[] countingSort(int[] arr, int maxValue){
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for (int value: arr){
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j<bucketLen; j++) {
            while(bucket[j]>0){
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
}