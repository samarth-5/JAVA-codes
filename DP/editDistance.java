public class editDistance 
{
    public static int operations(String s1,String s2)
    {
        int m=s1.length(),n=s2.length();
        int dp[][]=new int[m+1][n+1];
        //initialization
        for(int i=1;i<s1.length();i++)
        dp[i][0]=i;
        for(int j=1;j<s2.length();j++)
        dp[0][j]=j;
        //dp
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j]=dp[i-1][j-1];
                else
                {
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) 
    {
        String s1="intention",s2="execution";
        System.out.println(operations(s1,s2));
    }
}
