package pl.michol.calculator.engine.algorithms.implementation;

import org.springframework.stereotype.Service;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;
import pl.michol.calculator.engine.algorithms.model.SortResponse;

@Service
public class InsertionSort implements SortAlgorithm {
    @Override
    public SortResponse sort(Double[] array) {
        if (array == null || array.length <= 1) {
            return new SortResponse(new Double[]{}, 0L);
        }
        int size = array.length;
        long startTime = System.nanoTime();
        insertionSort(array, size-1);
        long stopTime = System.nanoTime();
        return new SortResponse(array, stopTime - startTime);
    }

    private void insertionSort(Double[] array, int n) {
        if(n>0){
            insertionSort(array, n-1);
            Double key = array[n];
            int j = n - 1;
            while (j >= 0 && array[j].compareTo(key)==1 ) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
