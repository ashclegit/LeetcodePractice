public class longestPalindromeSubString {

    public String longestPalSub(String str)
    {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        String res = null;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j<n;j++)
            {
                dp[i][j] = str.charAt(i) == str.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if(dp[i][j] && (res == null || j-i+1 > res.length()))
                {
                    res = str.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String test = "zwbbad";
        longestPalindromeSubString lps = new longestPalindromeSubString();
        System.out.println(lps.longestPalSub(test));
    }
}
