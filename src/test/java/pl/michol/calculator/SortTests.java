package pl.michol.calculator;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;
import pl.michol.calculator.engine.algorithms.implementation.BubbleSort;
import pl.michol.calculator.engine.algorithms.implementation.InsertionSort;
import pl.michol.calculator.engine.algorithms.implementation.MergeSort;
import pl.michol.calculator.engine.algorithms.implementation.QuickSort;
import pl.michol.calculator.engine.algorithms.model.SortResponse;

public class SortTests {

    private static final Double[] array = new Double[]{5.2,5.1,6.7,8.9,1.1,2.4};
    private static final Double[] result = new Double[]{1.1,2.4,5.1,5.2,6.7,8.9};

    @Test
    public void bubbleSortTest(){
        SortAlgorithm bubbleSort = new BubbleSort();
        SortResponse sortResponse = bubbleSort.sort(array);
        Assert.assertEquals(result,sortResponse.getResult());
    }

    @Test
    public void insertionSortTest(){
        SortAlgorithm insertionSort = new InsertionSort();
        SortResponse sortResponse = insertionSort.sort(array);
        Assert.assertEquals(result,sortResponse.getResult());
    }

    @Test
    public void quickSortTest(){
        SortAlgorithm quickSort = new QuickSort();
        SortResponse sortResponse = quickSort.sort(array);
        Assert.assertEquals(result,sortResponse.getResult());
    }

    @Test
    @Ignore
    public void mergeSortTest(){
        SortAlgorithm mergeSort = new MergeSort();
        SortResponse sortResponse = mergeSort.sort(array);
        Assert.assertEquals(result,sortResponse.getResult());
    }



}
