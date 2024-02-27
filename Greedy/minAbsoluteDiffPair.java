import java.util.*;
public class minAbsoluteDiffPair
{
    public static void main(String[] args) 
    {        
        int a[]={2,1,3};
        int b[]={3,2,1};
        Arrays.sort(a);
        Arrays.sort(b);
        int finalVal=0;
        for(int i=0;i<a.length;i++)
        {
            finalVal+=Math.abs(a[i]-b[i]);
        }
        System.out.println(finalVal);
    }
}