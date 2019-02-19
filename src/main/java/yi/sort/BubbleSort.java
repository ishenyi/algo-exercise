package yi.sort;

import java.util.Arrays;

import yi.common.Swap;
//import java.util.*;

public class BubbleSort {
    public int[] bubbleSort(int[] array) {
        for (int outer = array.length; outer > 1; outer --) {
            for(int i = 1; i < outer; i++) {
                if (array[i - 1] > array[i]) Swap.swap(i - 1, i, array);
            }
        }
        return array;
    }

    public int[] bubbleFastSort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        for (int i = 1;i<arr.length;i++) {
            boolean flag = true;
            for (int j = 0; j<arr.length-i;j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) break;
        }
        return arr;
    }
}
