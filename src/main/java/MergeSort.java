import java.util.Arrays;

public class MergeSort extends Sort {
    private int[] sortedArr;

    public MergeSort(int[] arr){
        this.arr = arr;
        this.sortName = "병합 정렬";
        this.sortedArr = new int[arr.length];
    }

    @Override
    public void sort() {
        mergeSort(0, arr.length - 1);
    }

    private void mergeSort(int startIdx, int endIdx){
        if(startIdx < endIdx){
            int middleIdx = (startIdx + endIdx) / 2;
            mergeSort(startIdx, middleIdx);
            mergeSort(middleIdx + 1, endIdx);
            merge(startIdx, middleIdx, endIdx);
        }
    }

    private void merge(int startIdx, int middleIdx, int endIdx){
        int firstPartIdx = startIdx;
        int secondPartIdx = middleIdx + 1;
        int sortedIdx = startIdx;

        while(firstPartIdx <= middleIdx && secondPartIdx <= endIdx){
            if(arr[firstPartIdx] <= arr[secondPartIdx]){
                sortedArr[sortedIdx++] = arr[firstPartIdx++];
            }else{
                sortedArr[sortedIdx++] = arr[secondPartIdx++];
            }

        }

        int remainsIdx = 0, remainsEnd = 0;
        if(firstPartIdx > middleIdx){
            remainsIdx = secondPartIdx;
            remainsEnd = endIdx;

        }else{
            remainsIdx = firstPartIdx;
            remainsEnd = middleIdx;
        }

        while (remainsIdx <= remainsEnd){
            sortedArr[sortedIdx++] = arr[remainsIdx++];
        }

        for(int i = startIdx; i <= endIdx ; i++){
            arr[i] = sortedArr[i];
        }
    }
}
