import java.util.Arrays;

public class hashTable {

    int[] theArray;
    int arraySize;
    int itemsinArray = 0;

    public static void main(String[] args) {
        hashTable ht = new hashTable(30);
        int[] elements = {3,4,6,7,8,67,90};
        ht.hashFunction(elements);
        ht.findKey(67);
    }

    public hashTable(int size)
    {
        arraySize = size;
        theArray= new int[size];
        Arrays.fill(theArray,-1);
    }

    public void hashFunction(int[] elements)
    {
        for(int i=0;i<elements.length;i++)
        {
            int ele = elements[i];
            int arrayIndex = ele % arraySize;
            while(theArray[arrayIndex] != -1)
            {
                ++arrayIndex;
                arrayIndex = arrayIndex%arraySize;
            }
            theArray[arrayIndex] = ele;
        }
    }

    public int findKey(int key)
    {
        int arrayIndexHash = key%arraySize;
        while(theArray[arrayIndexHash] != -1);
        {
            if(theArray[arrayIndexHash] == key)
            {
                return theArray[arrayIndexHash];
            }

            ++arrayIndexHash;
            arrayIndexHash = arrayIndexHash%arraySize;
        }
        throw new IllegalStateException();
    }

    public void removeKey(int key)
    {
        int arrayIndexHash = key%arraySize;
        while(theArray[arrayIndexHash] != -1);
        {
            if(theArray[arrayIndexHash] == key)
            {
                  if(arrayIndexHash < arraySize)
                  {
                      --arraySize;
                      for(int j=arrayIndexHash;j<arraySize;j++)
                      {
                          theArray[j] = theArray[j+1];
                      }
                  }
            }

            ++arrayIndexHash;
            arrayIndexHash = arrayIndexHash%arraySize;
        }
    }


}
