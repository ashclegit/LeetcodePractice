public class solveEquation {


    public String solveEquation(String equation)
    {
        String[] parts = equation.split("=");
        int[] res0 = solve(parts[0]);
        int[] res2 = solve(parts[1]);
        if(res0[0] == res2[0] && res0[1] == res2[1]) return "Infinite Solutions";
        else if(res0[0] == res2[0]) return "No Solution";
        System.out.println(res2[0] + "," + res0[1] + "," + res0[0] + "," + res2[1]);

        return "x=" + (res2[1] - res0[1])/(res0[0] - res2[0]);
    }

    public int[] solve(String part)
    {
        String[] tokens = part.split("(?=[+-])");
        int[] res = new int[2];
        for (String token : tokens)
        {
           if(token.equals("+x") || token.equals("x")) res[0]++;
           else if(token.equals("-x")) res[0]--;
           else if(token.contains("x")) res[0] = res[0] + Integer.parseInt(token.substring(0,token.length()-1));
           else res[1] += Integer.parseInt(token);
        }
        return res;
    }

    public static void main(String[] args) {


        String equation = "2x+3x-6x=x+2";
        solveEquation se = new solveEquation();
        String res =  se.solveEquation(equation);
        System.out.println(res);
    }


}
