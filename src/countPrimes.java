public class countPrimes {


    public int countPrime(int n)
    {
       int count = 0;
       boolean[] noPrime = new boolean[n];
       for(int i=2;i<n;i++)
       {
           if(noPrime[i] == false)
           {
               count++;
               for(int j=i*2;j<n;j += i)
               {
                   noPrime[j] = true;
               }
           }
       }
       return count;
    }

    public static void main(String[] args) {

        int n = 10;

        countPrimes cp = new countPrimes();
        System.out.print(cp.countPrime(n));
    }
}
