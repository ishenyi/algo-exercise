package yi.sort;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void test65318742() {
        int[] array = {6,5,3,1,8,7,4,2};
        int[] expect = {1,2,3,4,5,6,7,8};
        BubbleSort bubbleSort = new BubbleSort();
        array = bubbleSort.bubbleSort(array);
        assertThat(array, is(expect));
    }

    @Test
    public void testFast() {
        int[] array = {6,5,3,1,8,7,4,2};
        int[] expect = {1,2,3,4,5,6,7,8};
        BubbleSort bubbleSort = new BubbleSort();
        array = bubbleSort.bubbleFastSort(array);
        assertThat(array, is(expect));
    }
}

