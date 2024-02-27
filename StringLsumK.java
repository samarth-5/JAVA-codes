import java.util.*;
public class StringLsumK 
{
    public static void main(String[] args) 
    {
        String s="";
        int n=5,k=42,c=n-1;
        int ar[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            ar[i]=1;
        }
        k=k-n;
        while(k!=0)
        {
            if(k<=25)
            {
                ar[c]=ar[c]+k;
                break;
            }
            else
            {
                ar[c--]=1+25;
                k=k-25;
            }
        }
        //for(int i=0;i<n;i++)
        //System.out.println(ar[i]);
        for(int i=0;i<n;i++)
        {
            s=s+(char)(ar[i]+96);
        }
        System.out.println(s);
    }    
}
