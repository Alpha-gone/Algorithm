package sort;

public class QuickSort extends Sort{

    public QuickSort(int[] arr){
        this.arr = arr;
        this.sortName = "퀵 정렬";
    }

    @Override
    public void sort() {
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int left, int right){
        if(isLeftLessThanRight(left, right)){
            int pivot = partition(left, right);

            quickSort(left, pivot -1);
            quickSort(pivot + 1, right);
        }
    }

    private int partition(int left, int right){
        int pivot = getPivot(left, right);

        while(isLeftLessThanRight(left, right)){
            while (isLeftNotFindingBiggerThanPivot(left, pivot) && isLeftLessThanRight(left, right)){
                left++;
            }
            while (isRightNotFindingSmallerThanPivot(right, pivot) && isLeftLessThanRight(left, right)){
                right--;
            }

            if(isLeftLessThanRight(left, right)){
                swapValue(left, right);

                if(pivot == right){
                    return left;
                }
            }
        }

        if(right != pivot){
            swapValue(right, pivot);
        }

        return right;
    }

    private int getPivot(int left, int right){
        return (int)((left + right)/ 2.0);
    }
    private boolean isLeftLessThanRight(int left, int right){
        return left < right;
    }

    private boolean isLeftNotFindingBiggerThanPivot(int left, int pivot){
        return arr[left] < arr[pivot];
    }

    private boolean isRightNotFindingSmallerThanPivot(int right, int pivot){
        return arr[right] >= arr[pivot];
    }

}
