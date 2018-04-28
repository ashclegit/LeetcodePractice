public class productExceptItself {

    public int[] claProductExcept(int[] nums)
    {
        int[] res = new int[nums.length];
        res[0] = 1;

        for(int i= 1;i<nums.length;i++)
        {
            res[i] = res[i-1] * nums[i-1];
        }

        int rightMost = 1;
        for(int j = nums.length-1;j>=0;j--)
        {
            res[j] = res[j] * rightMost;
            rightMost = rightMost * nums[j];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        productExceptItself ps = new productExceptItself();
        int[] res = ps.claProductExcept(nums);
        for(int i : res)
        {
            System.out.println(i);
        }
    }
}
