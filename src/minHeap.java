import java.util.Arrays;

public class minHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex){return 2*parentIndex + 1;}
    private int getRightChildIndex(int parentIndex){return 2*parentIndex + 2;}
    private int getParentIndex(int childIndex){return (childIndex - 1 )/2;}

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){return getParentIndex(index) >= 0 ;}

    private int leftChild(int index){return items[getLeftChildIndex(index)];}
    private int rightChild(int index){return items[getRightChildIndex(index)];}
    private int getParent(int index){return items[getParentIndex(index)];}

    private void swap(int indexOne,int indexTwo)
    {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity()
    {
        if(size == capacity)
        {
            items = Arrays.copyOf(items,capacity * 2);
            capacity = capacity * 2;
        }
    }

    private int poll()
    {
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private int peek()
    {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    private void insert(int item)
    {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyDown()
    {
        int index = 0;
        while(hasLeftChild(index))
        {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index))
            {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex])
            {
                break;
            } else {

                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp()
    {
        int index = size -1 ;
        while(hasParent(index) && getParent(index) > items[index])
        {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public void printHeap()
    {
        System.out.println("Heap = ");
        for (int i = 0; i < size; i++)
            System.out.print(items[i] +" ");
        System.out.println();
    }

    public static void main(String[] args) {
        minHeap bh = new minHeap();
        bh.insert(3);
        bh.insert(2);
        bh.insert(1);
        bh.insert(8);
        bh.insert(5);
        System.out.println("Min Element :- "+bh.peek());
        bh.printHeap();
        bh.poll();
        System.out.println("Min Element :- "+bh.peek());
        bh.printHeap();
    }
}
