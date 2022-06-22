package sort;

public class HeapSort extends Sort{
    public HeapSort(int[] arr){
        this.arr = arr;
        this.sortName = "힙 정렬";
    }
    
    @Override
    public void sort() {
        int lastIdx = arr.length - 1;

        if(lastIdx < 1){
            return;
        }

        int parentIdx = getParent(lastIdx);

        for(int rootIdx = parentIdx; rootIdx >= 0; rootIdx--){
            heapify(rootIdx, lastIdx);
        }

        for (int fillIdx = lastIdx; fillIdx > 0; fillIdx--){
            swapValue(0, fillIdx);

            int nextFillIdx = fillIdx -1;
            heapify(0, nextFillIdx);
        }
    }


    private int getParent(int childIdx){
        return (childIdx - 1) / 2;
    }
    
    private void heapify(int parentIdx, int lastIdx){
        int largestValueIdx = parentIdx;
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;

        if(isIndexUnderLastIndex(leftChildIdx, lastIdx) &&
                isValueBiggerThanLargestValue(leftChildIdx, largestValueIdx)){
            largestValueIdx = leftChildIdx;
        }

        if(isIndexUnderLastIndex(rightChildIdx, lastIdx) &&
                isValueBiggerThanLargestValue(rightChildIdx, largestValueIdx)){
            largestValueIdx = rightChildIdx;
        }

        if(parentIdx != largestValueIdx){
            swapValue(largestValueIdx, parentIdx);
            heapify(largestValueIdx, lastIdx);
        }
    }

    private boolean isIndexUnderLastIndex (int idx, int lastIdx){
        return idx <= lastIdx;
    }

    private boolean isValueBiggerThanLargestValue(int childIdx, int largestIdx){
        return arr[childIdx] > arr[largestIdx];
    }
}
