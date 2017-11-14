package pl.michol.calculator.engine.algorithms.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michol.calculator.engine.algorithms.SortAlgorithm;

@Service
public class SortAlgorithmFactory {

    private final BubbleSort bubbleSort;
    private final InsertionSort insertionSort;
    private final QuickSort quickSort;

    @Autowired
    public SortAlgorithmFactory(BubbleSort bubbleSort, InsertionSort insertionSort, QuickSort quickSort) {
        this.bubbleSort = bubbleSort;
        this.insertionSort = insertionSort;
        this.quickSort = quickSort;
    }

    public SortAlgorithm getAlgorithm(String name){
        switch (name){
            case "bubble":
                return bubbleSort;
            case "quick":
                return quickSort;
            case "insertion":
                return insertionSort;
            default:
                return bubbleSort;
        }
    }
}
