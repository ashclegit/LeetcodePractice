public class recursiveSum {

    public int recurse(int n)
    {
        /*if(n == 0) return 0;
        if(n == 1) return 1;
        return recurse(n-1) + n;*/
        int sum = 0;
        for(int i =0;i<=n;i++)
        {
            sum = sum + i;
        }
        return sum;

    }

    public static void main(String[] args) {
        recursiveSum rs = new recursiveSum();
        int n = 100000;
        int sum = rs.recurse(n);
        System.out.println(sum);
    }
}
