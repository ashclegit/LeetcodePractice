public class quickSelect {
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (/*lo < hi*/true) {
            int j = partition(nums, lo, hi);
            if(j == k) {
                return nums[k];
            } else if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;;
            }
        }
        //return nums[k];
    }


    public int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                exch(arr,i,j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        exch(arr,i+1,high);
        return i+1;
    }



    public void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        quickSelect kl = new quickSelect();
        int arr[] = {1, 23, 12, 9,
                30, 2, 50};
        int k = 3;
        System.out.println(kl.findKthLargest(arr,k));
    }



}