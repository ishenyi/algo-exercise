package yi.sort;

import java.util.Arrays;

public class QuickSort {
    // sort function
    public static int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length-1);
    }

    /**
     * quicksort()
     * param: partitionIndex
     */
    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right){
            int partitionIndex = partition(arr,left,right);
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);//
        }
        return arr;
    }


    /**
     * partiton()
     * param: pivot, index
     * return index
     */
    private static int partition(int[] arr , int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i<=right; i++) {//右侧<=极限，右侧极限是个变量
            if (arr[i]< arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);//把pivot放在中间，index是右侧大数起始位
        return index-1;
    }

    /**
     * swap()
     * 
     */
    private static void swap(int[] arr,int i,int j) { //可以不用返回值
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
        //return arr;
    }

    public static void main(String[] args){
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = sort(arr);
        for (int entity:arr) System.out.println(entity);
    }

    
}