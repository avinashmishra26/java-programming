package cracking.coding.interview;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class MinHeapImpl {

    int[] minHeapArr;
    int lastPos = -1;

    public MinHeapImpl(int arrSize) {
        minHeapArr = new int[arrSize];
    }

    public void insert(int data) {
        minHeapArr[++lastPos] = data;
        heapifyFromDown();
    }

    public void heapifyFromDown() {
        //if ()
    }

    public void heapify() {
        //if ()
    }

    public int getMini() {
        int res = minHeapArr[0];
        minHeapArr[0] = minHeapArr[lastPos];
        lastPos--;
        heapify();
        return res;
    }

}
