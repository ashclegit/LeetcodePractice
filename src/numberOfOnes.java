public class numberOfOnes {

    public static void main(String[] args) {
        int a = 1;
        int b = 6;
        int out = 0;
        int n = a ^ b;
        while(n!=0)
        {
            out += n&1;
            n = n >>> 1;
        }
        System.out.print(out);
    }
}
