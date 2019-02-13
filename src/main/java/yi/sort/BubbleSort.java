package yi.sort;

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
}