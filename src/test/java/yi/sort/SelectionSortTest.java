package yi.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SelectionSortTest{
    @Test
    public void Test7234165(){
        int[] sourceArray = {7,2,3,4,1,6,5};
        int[] expect = {1,2,3,4,5,6,7};
        int[] arr = new SelectionSort().sort(sourceArray);
        assertThat(arr, is(expect));
    }
}