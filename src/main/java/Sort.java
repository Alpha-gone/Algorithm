import java.util.Arrays;

abstract public class Sort {
    protected int[] arr;
    protected String sortName;

    public abstract void sort();

    public String getName(){
        return sortName;
    }

    protected void showResult(){
        System.out.println("정렬 결과 : " + Arrays.toString(arr));
        System.out.println();
    }

    protected void swapValue(int sortIdx, int targetIdx){
        int temp = arr[sortIdx];
        arr[sortIdx] = arr[targetIdx];
        arr[targetIdx] = temp;
    }
}
