public class BubbleSort extends Sort{
    public BubbleSort(int[] arr){
        this.arr = arr;
        this.sortName = "버블 정렬";
    }

    @Override
    public void sort() {
        for (int blockCount = 0; blockCount < arr.length; blockCount++) {
            for (int searchIdx = 1; searchIdx < arr.length - blockCount; searchIdx++) {
                if (arr[searchIdx - 1] > arr[searchIdx]) {
                    swapValue(searchIdx - 1, searchIdx);
                }
            }
        }
    }
}
