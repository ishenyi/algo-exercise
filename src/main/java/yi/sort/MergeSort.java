/**
 * 归并操作
归并操作（merge），也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。

递归法（Top-down）
申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
设定两个指针，最初位置分别为两个已经排序序列的起始位置
比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
重复步骤3直到某一指针到达序列尾
将另一序列剩下的所有元素直接复制到合并序列尾
迭代法（Bottom-up）
原理如下（假设序列共有 {\displaystyle n} n个元素）：

将序列每相邻两个数字进行归并操作，形成 {\displaystyle ceil(n/2)} {\displaystyle ceil(n/2)}个序列，排序后每个序列包含两/一个元素
若此时序列数不是1个则将上述序列再次归并，形成 {\displaystyle ceil(n/4)} {\displaystyle ceil(n/4)}个序列，每个序列包含四/三个元素
重复步骤2，直到所有元素排序完毕，即序列数为1
 */
package yi.sort;
import java.util.Arrays;


public class MergeSort {
    public static int[] sort(int[] sourcrArray) {
        int[] arr = Arrays.copyOf(sourcrArray, sourcrArray.length);
        if (arr.length <2){
            return arr;
        }
        int middle = (int)Math.floor(arr.length/2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left),sort(right));
    }

    protected static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        while(left.length>0 && right.length>0) {// 把左右【0】进行比较知道，左右其中一个长度为0
            if (left[0]<=right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);                
            }
        }
        while(left.length>0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while(right.length>0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println((111>>1)+1);
        // System.out.println(Math.floor(7/2));
        // System.out.println(Math.floor(3/2));
        // int[] a={1,2,3};
        // int[] c = Arrays.copyOfRange(a, 0, 1); //[from,to)状态
        // for(int entity:c)System.out.println(entity);
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = mergeSort(arr);
        for (int entity:arr) System.out.println(entity);
    }

    //要重写归并排序，主要是merge的方法，和递归调用
    //sort 算法主要是递归，递归的跳出就是，数组的长度不足2了
    public static int[] mergeSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length<2) return arr;
        int middle = (int)Math.floor(arr.length/2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);//这里是左闭右开的方式
        return mergeF(mergeSort(left),mergeSort(right));
    }

    private static int[] mergeF(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i=0;
        while(left.length>0 && right.length>0) {
            if(left[0]<=right[0]){
                result[i] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
                i++;
            }else{
                result[i] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
                i++;
            }
        }
        while(left.length>0) {
            // for(int entity:left) {
            //     result[i++] = entity;
            // } 这里不能用for循环了
            result[i++] = left[0]; // bug fix 必须i要递增
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while(right.length>0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}