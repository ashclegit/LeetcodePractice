import java.util.PriorityQueue;

public class kthLargest {

    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        kthLargest kl = new kthLargest();
        int arr[] = {1, 23, 12, 9,
                30, 2, 50};
        int k = 3;
        kl.findKthLargest(arr,k);
    }
}
