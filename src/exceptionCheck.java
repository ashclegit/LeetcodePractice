public class exceptionCheck {

    public static void main(String[] args) {

        int i = 1;
        int j = 0;

        try{
                i -= 1;
                try
                {
                    j = 1/i;
                }
                catch(IllegalStateException e)
                {
                    throw e;
                }
                /*finally
                {
                    System.out.println("hi ashwin");
                    i++;
                }*/
        }
        catch(Exception e)
        {
            System.out.println("caught in outer catch");
            i = i+2;
        }
        /*finally {
            System.out.println("caught in outer finally");
            i = i-1;
        }*/
        System.out.println(i);
    }
}
