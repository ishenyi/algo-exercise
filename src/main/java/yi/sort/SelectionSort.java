package yi.sort;

public class SelectionSort {
    public static int[] sort(int[] array) {
        for (int i=0; i<array.length-1;i++) {
            int min = i;
            for (int j=i+1; j<array.length;j++) {
                if (array[j]<array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {12,4,5,7,2,23,57,8,0};
        arr = sort(arr);
        for (int entity:arr) System.out.println(entity);
    }
}