package pl.michol.calculator.engine.algorithms.implementation;

import org.springframework.stereotype.Service;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;
import pl.michol.calculator.engine.algorithms.model.SortResponse;
import pl.michol.calculator.engine.utils.SortUtils;

@Service
public class BubbleSort implements SortAlgorithm {

    @Override
    public SortResponse sort(Double[] array) {
        if (array == null || array.length <= 1) {
            return new SortResponse(new Double[]{}, 0L);
        }
        int size = array.length;
        long startTime = System.nanoTime();
        bubbleSort(array, size);
        long stopTime = System.nanoTime();
        return new SortResponse(array, stopTime-startTime);
    }

    private void bubbleSort(Double[] array, int size) {
        do {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    SortUtils.swap(array, i, i+1);
                }
            }
            size -= 1;
        } while (size > 1);
    }
}
