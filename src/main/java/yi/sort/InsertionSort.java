package yi.sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] array){
        
        for (int i =1; i<array.length; i++){
            int insert = array[i];//取出要插入的值
            for (int j=i-1; j>=0;j--){//遍历有序的数组
                if(array[j]>insert){//从有序数组右侧的数开始，一一比较，大与insert值的
                    array[j+1] = array[j];//4，5，12，7，交换位置
                    array[j] = insert;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = insertionSortReview1(arr);
        for (int entity:arr) System.out.println(entity);
    }

    public static int[] insertionSortReview1(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        if (arr.length<2){
            return arr;
        }
        for (int i = 1;i<arr.length;i++){
            int insert = arr[i];
            // for (int j = i-1; j>=0;j--) { // 插入排序的精髓 对左侧有序数列进行排序
            //     if(arr[j]>insert) {
            //         // int tmp = arr[j];
            //         // arr[j] = insert;
            //         arr[j+1] = arr[j];                    
            //         arr[j] = insert;
            //     }
            // }
            int j = i-1;
            while(j>=0 && arr[j]>insert){
                arr[j+1] = arr[j];
                j -=1;
            }
            arr[j+1] = insert; //注意上一步循环的时候这里多减了1；
        }
        return arr;
    }
}