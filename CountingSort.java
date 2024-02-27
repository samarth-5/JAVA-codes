public class CountingSort
{
    public static int[] Count(int ar[])    
    {
        int max=0,j=0;        
        for(int i=0;i<ar.length;i++)
        max=Math.max(max,ar[i]);
        int c[]=new int[max+1];
        for(int i=0;i<ar.length;i++)
        c[ar[i]]++;
        for(int i=0;i<c.length;i++)
        {
            while(c[i]!=0)
            {
                ar[j]=i;
                j++;
                c[i]--;
            }
        }
        return ar;
    }
    public static void main(String Args[])
    {
        int ar[]={3,6,2,1,8,7,4,5,3,1};
        ar=Count(ar);
        for(int i=0;i<ar.length;i++)
        System.out.print(ar[i]+" ");
    }
}
