public class knapsack01 
{
    public static int knapsack(int val[],int wt[],int w,int n)//O(2^n)
    {
        if(w==0 || n==0)
        return 0;
        if(wt[n-1]<=w)//valid
        {
            //include
            int ans1=val[n-1]+knapsack(val, wt, w-wt[n-1], n-1);
            //exclude
            int ans2=knapsack(val, wt, w,n-1);
            return Math.max(ans1, ans2);
        }
        else//not valid
        {
            //exclude
            return knapsack(val, wt, w,n-1);
        }
    }
    public static int memoization(int val[],int wt[],int w,int n,int dp[][])//O(n*w)
    {
        if(w==0 || n==0)
        return 0;
        if(dp[n][w] != -1)
        return dp[n][w];
        if(wt[n-1]<=w)//valid
        {
            //include
            int ans1=val[n-1]+knapsack(val, wt, w-wt[n-1], n-1);
            //exclude
            int ans2=knapsack(val, wt, w,n-1);
            dp[n][w]=Math.max(ans1, ans2);
            return dp[n][w];
        }
        else//not valid
        {
            //exclude
            dp[n][w]= knapsack(val, wt, w,n-1);
            return dp[n][w];
        }
    }
    public static int tabulation(int val[],int wt[],int W)
    {
        int dp[][]=new int[val.length+1][W+1];
        int n=val.length;
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++)
        {
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<W+1;j++)
            {
                int v=val[i-1];//ith item val
                int w=wt[i-1];//ith item wt
                //valid
                if(w<=j)
                {
                    //include
                    int incProfit=v+dp[i-1][j-w];
                    //exclude
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }
                else
                {
                    //invalid
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        //System.out.println(knapsack(val,wt,w,val.length));
        int dp[][]=new int[val.length+1][w+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            dp[i][j]=-1;
        }
        //System.out.println(memoization(val,wt,w,val.length,dp));
        System.out.println(tabulation(val,wt,w));
    }
}
