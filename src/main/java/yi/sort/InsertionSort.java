package yi.sort;



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

    public void main(String[] args) {
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = sort(arr);
        for (int entity:arr) System.out.println(entity);
    }
}