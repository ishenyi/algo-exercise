package yi.sort;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public static void test987654321(){
        int[] array = {9,8,7,6,5,4,3,2,1};
        int[] expect = {1,2,3,4,5,6,7,8,9};
        MergeSort mergeSort = new MergeSort();
        array = mergeSort.sort(array);
        assertThat(array, is(expect));
    }

    @Test
    public void test21(){
        int[] array = {2,1};
        int[] expect = {1,2};
        MergeSort mergeSort = new MergeSort();
        array = mergeSort.sort(array);
        assertThat(array, is(expect));
    }
}