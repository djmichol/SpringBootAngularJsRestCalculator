package pl.michol.calculator.engine.algorithms.implementation;

import org.springframework.stereotype.Service;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;
import pl.michol.calculator.engine.algorithms.model.SortResponse;
import pl.michol.calculator.engine.utils.SortUtils;

@Service
public class QuickSort implements SortAlgorithm {
    @Override
    public SortResponse sort(Double[] array) {
        if (array == null || array.length <= 1) {
            return new SortResponse(new Double[]{}, 0L);
        }
        int size = array.length;
        long startTime = System.nanoTime();
        quickSort(array, 0, size-1);
        long stopTime = System.nanoTime();
        return new SortResponse(array, stopTime-startTime);
    }

    private void quickSort(Double[] array, int l, int r) {
        if(l<r){
            int i = partition(array, l,r);
            quickSort(array, l, i-1);
            quickSort(array, i+1, r);
        }
    }

    private int partition(Double[] array, int l, int r) {
        int partitionIndex = WybierzPunktPodzialu(l, r);
        Double pivot = array[partitionIndex];
        SortUtils.swap(array, partitionIndex, r);
        int actualPositions = l;
        for(int j=l; j<r ; j++){
            if(array[j].compareTo(pivot)==-1){
                SortUtils.swap(array, j, actualPositions);
                actualPositions = actualPositions+1;
            }
        }
        SortUtils.swap(array, actualPositions, r);
        return actualPositions;
    }

    private int WybierzPunktPodzialu(int l, int r) {
        return l + (r-l) % 2;
    }
}
