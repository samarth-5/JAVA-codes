class mountainRanges
{
    public static int ranges(int n)//O(n^2)
    {
        //at any moment no. of downstrokes cannot be graeter than no. of upstrokes
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++)
        {
            for(int j=0;j<i;j++)
            {
                int inside=dp[j];
                int outside=dp[i-j-1];
                dp[i]+=inside*outside;
            }
        }
        //n pairs
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(ranges(5));
    }
}