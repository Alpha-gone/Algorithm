package sort;

import java.util.*;

public class RadixSort extends Sort {
    private final int RADIX = 10;
    private ArrayDeque<Integer>[] buckets;

    public RadixSort(int[] arr){
        this.arr = arr;
        this.sortName = "기수 정렬";
        this.buckets = new ArrayDeque[10];
        initBuckets();
    }

    @Override
    public void sort() {
        final int EXP = getEXP();
        radixSort(EXP);
    }

    private void initBuckets(){
        for (int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayDeque<>();
        }
    }
    private int getEXP(){
        int maxValue = Arrays.stream(arr).max().getAsInt();
        return (int)Math.log10(maxValue) + 1;
    }

    private void radixSort(int EXP){
        int factor = 1;

        for(int digit = 0; digit < EXP; digit++){
            for (int idx = 0; idx < arr.length; idx++){
                enQueueValue(idx, factor);
            }

            factor *= 10;

            pushSortedValue();

        }
    }

    private void enQueueValue(int idx, int factor){
        int position = (arr[idx] / factor) % 10;
        buckets[position].offer(arr[idx]);
    }

    private void pushSortedValue(){
        int pushIdx = 0;
        for(ArrayDeque<Integer> queue : buckets){
            while (!queue.isEmpty()){
                arr[pushIdx++] = queue.poll();
            }
        }
    }

}

