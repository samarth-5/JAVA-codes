import java.util.*;
class Kadane
{
    public static void Kadane(int ar[])
    {
        int ms=Integer.MIN_VALUE,cs=0;
        for(int i=0;i<ar.length;i++)
        {
            cs=cs+ar[i];
            if(cs<0)
            cs=0;
            ms=Math.max(ms,cs);
        }
        System.out.println("Maximum SubArray Sum:"+ms);
    }
    public static void main(String Args[])
    {
        int ar[]={-2,-3,4,-1,-2,1,5,-3};
        Kadane(ar);
    }
}
