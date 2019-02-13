package yi.sort;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
public class QuickSortTest{
    QuickSort qs = new QuickSort();

    @Test
    public void test31254(){
        int[] arr = {3,1,2,5,4};
        int[] exp = {1,2,3,4,5};
        arr = qs.sort(arr);
        assertThat(arr, is(exp));
    }
}