package org.example;

import java.util.Arrays;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MergeTest {
    @Test
    public void testMerge()
    {
        ArrayList<Integer> preSortedArray = new ArrayList<Integer>(Arrays.asList(1, 4, 4, 5, 9, 10, 12, 14));
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>(Arrays.asList(12, 14, 1, 5, 4, 9, 4, 10));
        MergeSort<Integer> newMerge = new MergeSort<Integer>();
        newMerge.setArray(unsortedArray);
        newMerge.sort();
        assertEquals(preSortedArray, newMerge.getArray());
    }
}
