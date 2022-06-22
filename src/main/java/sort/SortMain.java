package sort;

import java.util.Arrays;

public class SortMain {
    public static void main(String[] args) {
        int[] targetArr = {69, 10, 30, 2, 16, 8, 31, 22};

        System.out.println("정렬 전 배열 : " + Arrays.toString(targetArr));
        System.out.println();

        sorter(new SelectionSort(targetArr.clone()));

        sorter(new BubbleSort(targetArr.clone()));

        sorter(new QuickSort(targetArr.clone()));

        sorter(new InsertSort(targetArr.clone()));

        sorter(new ShellSort(targetArr.clone()));

        sorter(new MergeSort(targetArr.clone()));

        sorter(new RadixSort(targetArr.clone()));

        sorter(new HeapSort(targetArr.clone()));
    }

    private static void sorter(Sort sortClazz){
        System.out.println("-".repeat(10) + sortClazz.getName() + "-".repeat(10));

        sortClazz.sort();

        sortClazz.showResult();
    }

}
