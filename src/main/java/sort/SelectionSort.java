package sort;

public class SelectionSort extends Sort{
    public SelectionSort(int[] arr){
        this.arr = arr;
        this.sortName = "선택 정렬";
    }

    @Override
    public void sort(){
        for (int sortIdx = 0 ; sortIdx <  arr.length - 1; sortIdx++){
            int minIdx = sortIdx;

            for(int searchIdx = sortIdx + 1; searchIdx < arr.length; searchIdx++){
                if(isMinSearchValue(minIdx, searchIdx)){
                    minIdx = searchIdx;
                }
            }

            swapValue(sortIdx, minIdx);
        }
    }

    private boolean isMinSearchValue(int minIdx, int searchIdx){
        return arr[minIdx] > arr[searchIdx];
    }
}
