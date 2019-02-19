package yi.sort;

import java.util.Arrays;

public class ShellSort{
    public static int[] sort(int[] array) {
        //确定步长
        int gap = 1;
        while(gap<array.length){
            gap = gap * 3 +1;
        }
        while(gap>0){
            for(int i=gap; i<array.length;i++){
                int tmp = array[i];
                int j=i-gap;
                while(j>=0 && array[j] > tmp){
                    array[j+gap] = array[j];
                    j-=gap;
                }
                array[j+gap] = tmp;
            }
            gap = (int)Math.floor(gap/3);
        }
        return array;
    }

/**
 * 希尔排序的逻辑
 * 首先确定步长
 * 在步长大于1的情况下循环，每次补步长减半
 * i从步长开始，逐渐+1和j进行比较，j的正好是一个步长
 * j的值逐渐减小，j>=0.
 * 如果i的大了，把j的值复制到i位置上，j的值
 * @param arr
 * @return
 */


    public static int[] sort2(int[] arr) {
        int step=(int)Math.floor(arr.length/2);
        int i,j,tmp;
        while (step>=1) {
            for(i = step; i< arr.length;  i++){
                tmp = arr[i];
                j = i-step;
                // while(j>=0 && arr[j]>tmp){
                //     arr[j+step] = arr[j];
                //     j = j-step;
                // }
                // arr[j+step] = tmp;
                for (;j>=0;j -= step){// 
                    if( arr[j]>tmp){
                        arr[j+step]=arr[j];
                        arr[j]=tmp;
                    }
                }
            }
            step = step/2;
        }
        
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,3,1};
        arr = shellSortStandard(arr);
        for (int entity:arr) System.out.println(entity);
    }

    //shell算法
    public static int[] shellSortStandard(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int step = (int)Math.floor(arr.length/2);
        while(step>=1){

            for(int i = step; i<arr.length; i++){
                int insert = arr[i];
                int j=i-step;
                while(j>=0 && arr[j]>insert){//这里不能写arr[i],因为arr[i]会变化
                    arr[j+step] = arr[j];
                    j -= step;
                }
                arr[j+step] = insert;
                
            }

            step = (int)Math.floor(step/2);
        }
        return arr;

    }
}