package pl.michol.calculator.engine.algorithms.implementation;

import org.springframework.stereotype.Service;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;
import pl.michol.calculator.engine.algorithms.model.SortResponse;

@Service
public class MergeSort implements SortAlgorithm {
    @Override
    public SortResponse sort(Double[] array) {
        if (array == null || array.length <= 1) {
            return new SortResponse(new Double[]{}, 0L);
        }
        int size = array.length;
        long startTime = System.nanoTime();
        mergeSort(array);
        long stopTime = System.nanoTime();
        return new SortResponse(array, stopTime - startTime);
    }

    private void mergeSort(Double[] array) {
        //TODO
    }

}
