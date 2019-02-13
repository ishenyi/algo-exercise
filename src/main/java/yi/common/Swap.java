package yi.common;

import java.util.*;
import yi.datastructure.*;

public class Swap {
    private Swap(){};
    public static void swap(int leftIdx, int rightIdx, int[] array) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }
    public static void swap(int leftIdx, int rightIdx, List<Node> list) {
        Node temp = list.get(leftIdx);
        list.set(leftIdx, list.get(rightIdx));
        list.set(rightIdx, temp);
    }
}