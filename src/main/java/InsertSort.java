public class InsertSort extends Sort{

    public InsertSort(int[] arr){
        this.arr = arr;
        this.sortName = "삽입 정렬";
    }

    @Override
    public void sort() {
        for (int unSortedIdx = 1; unSortedIdx < arr.length ; unSortedIdx++){
            int target = arr[unSortedIdx];
            int prevIdx = unSortedIdx - 1;

            while (isbBiggerThantarget(prevIdx, target)){
                arr[prevIdx + 1] = arr[prevIdx];
                prevIdx--;
            }

            arr[prevIdx + 1] = target;
        }
    }

    private boolean isbBiggerThantarget(int prevIdx, int target){
        return prevIdx >= 0 && arr[prevIdx] > target;
    }
}
