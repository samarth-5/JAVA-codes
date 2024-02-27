import java.util.*;
public class longestIncreasingSubsequence 
{
    //longest common subsequence between sorted array and given array
    //it will be longest increasing subsequence
    public static int lis(int ar[])//O(m*n)
    {
        //for getting unique elements
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<ar.length;i++)
        set.add(ar[i]);
        int ar2[]=new int[set.size()];
        int i=0;
        for(int num:set)
        {
            ar2[i++]=num;
        }
        Arrays.sort(ar2);
        return lcs(ar,ar2);
    }
    public static int lcs(int ar1[],int ar2[])
    {
        int m=ar1.length,n=ar2.length;
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(ar1[i-1]<ar2[j-1])
                dp[i][j]=dp[i-1][j-1]+1;
                else
                {
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) 
    {
        int ar[]={50,3,10,7,40,80};
        System.out.println(lis(ar));//3,7,40,80
    }    
}
