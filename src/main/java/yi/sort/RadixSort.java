package yi.sort;

import java.util.Arrays;

public class RadixSort {
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr,maxDigit);
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;
         
        for (int i = 0; i<maxDigit;i++,dev *=10, mod*=10){
            int[][] count = new int[mod*2][0];
            
            for (int j=0; j<arr.length;j++){
                int bucket = ((arr[j] % mod)/dev) + mod;
                count[bucket] = arrayAppend(count[bucket],arr[j]);
            }

            int index = 0;
            for (int[] bucket: count) {
                for(int value: bucket){
                    arr[index++] = value;
                }
            }
        }
        return arr;
    }

    private int[] arrayAppend(int[] array, int value){
        int[] arr = Arrays.copyOf(array, array.length+1);
        arr[arr.length-1] = value;
        return arr;
    }

    private int getMaxDigit(int[] arr){
        int maxValue = getMaxValue(arr);
        return getNumberLen(maxValue);
    }

    private int getMaxValue(int[] arr){
        int maxValue = arr[0];
        for (int value: arr){
            if (value>maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int getNumberLen(int value){
        if( value == 0){
            return 1;
        }
        int length = 0;
        for (long tmp = value; tmp!=0; tmp/=10){
            length++;
        }
        return length;
    }
}