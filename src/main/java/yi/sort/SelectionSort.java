package yi.sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] array) {
        for (int i=0; i<array.length-1;i++) {
            int min = i;
            for (int j=i+1; j<array.length;j++) {
                if (array[j]<array[min]) {
                    min = j;
                }
            }
            if(i!=min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = sortByReview(arr);
        for (int entity:arr) System.out.println(entity);
    }

    public static int[] sortByReview(int[] sourceArr){
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        for (int i = 0; i<arr.length-1;i++){  // 这里比较的次数为数组长度-1，不减1也没有问题。
            int minIndex = i; // 选择排序的意思是，select one elements as the minest one
            for(int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    // int tmp = arr[j];     // 不要在里面交换，在外面交换更加高效
                    // arr[j] = arr[i];
                    // arr[i] = tmp;
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp  = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }

        }
        return arr;
    }
}