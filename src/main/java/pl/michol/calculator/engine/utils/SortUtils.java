package pl.michol.calculator.engine.utils;

public class SortUtils {

    public static void swap(Double[] array, int i, int j) {
        Double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
