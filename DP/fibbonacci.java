public class fibbonacci
{
    public static int fibbo(int n,int f[])//O(n)
    {
        if(n==0 || n==1)
        return n;
        //fib(n) is already calculated
        if(f[n]!=0)
        return f[n];
        f[n]=fibbo(n-1,f)+fibbo(n-2,f);
        return f[n];
    }
    //tabulation
    public static int fib(int n)//O(n)
    {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        //int f[]=new int[n+1];
        //System.out.println(fibbo(5, f));
        System.out.println(fib(n));
    }
}