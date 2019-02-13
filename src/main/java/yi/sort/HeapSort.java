package yi.sort;

import java.util.Arrays;

public class HeapSort{
    
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr,len);
        for(int i= len-1;i>0;i--){
            swap(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len){
        //从数组的中间，知道第一个元素
        for (int i= (int)Math.floor(len/2);i>=0;i--){ // 知道第一个为0的数
            heapify(arr,i,len);
        }
    }

    private void heapify(int[] arr,int i,int len){
        /**‘
         * 完全二叉树有个特性：
         * 左边子节点位置 = 当前父节点的两倍 + 1，
         * 右边子节点位置 = 当前父节点的两倍 + 2
         */
        int left = 2*i +1;
        int right = 2*i +2;
        //把当前父节点看成是最大的
        int largest = i;

        if(left<len && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<len && arr[right]>arr[largest]){
            largest = right;
        }
        if(largest != i){
            swap(arr,i,largest);
            heapify(arr,largest,len);
        }
    }

    private void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        int[] arr = new int[] { 5, 2, 7, 3, 6, 1, 4};
        int[] rs = new HeapSort().sort(arr);
        System.out.println(Arrays.toString(rs));
    }
}