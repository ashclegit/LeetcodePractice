public class thirdMaxElement {

    public int findThird(int[] arr)
    {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for(Integer n : arr)
        {
            if(n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax)) continue;

            if(firstMax == null || n > firstMax)
            {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            }
            else if(secondMax == null || n> secondMax)
            {
                thirdMax = secondMax;
                secondMax = n;
            }
            else
            {
                thirdMax = n;
            }
        }
        return thirdMax == null ? firstMax : thirdMax;
    }

    public static void main(String[] args) {

            int[] arr = {2,2,3,1};

            thirdMaxElement tm = new thirdMaxElement();
            System.out.println(tm.findThird(arr));

    }
}
