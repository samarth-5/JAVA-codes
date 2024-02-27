public class longestCommonSubstring 
{
    public static int lcs(String s1,String s2,int m,int n,int dp[][])
    {
        int ans=0;
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else
                {
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        String s1="ABCDE",s2="ABGCE";
        int m=s1.length(),n=s2.length();
        int dp[][]=new int[m+1][n+1];
        System.out.println(lcs(s1,s2,m,n,dp));
    }    
}
