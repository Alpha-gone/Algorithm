public class ShellSort extends Sort{

    public ShellSort(int[] arr){
        this.arr = arr;
        this.sortName = "셸 정렬";
    }

    @Override
    public void sort() {
        int interval = arr.length / 2;

        while (interval >= 1){
            for(int startIdx = 0; startIdx < interval; startIdx++){
                intervalShort(startIdx, arr.length - 1, interval);

                interval /= 2;
            }
        }
    }
    private void intervalShort(int start, int end, int interval){

        for(int startIdx = start + interval ; startIdx <= end; startIdx += interval){
            int item = arr[startIdx];

            int insertIdx = startIdx - interval;
            for (; insertIdx >= start && item < arr[insertIdx]; insertIdx -= interval){
                arr[insertIdx + interval] = arr[insertIdx];
            }

            arr[insertIdx + interval] = item;
        }
    }
}
