import java.util.*;
public class heapSort 
{
    public static void heapify(int ar[],int i,int size)
    {
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<size && ar[left]>ar[maxIdx])
        maxIdx=left;
        if(right<size && ar[right]>ar[maxIdx])
        maxIdx=right;
        if(maxIdx != i)
        {
            //swap
            int temp=ar[i];
            ar[i]=ar[maxIdx];
            ar[maxIdx]=temp;
            heapify(ar,maxIdx, size);
        }
    }
    public static void sort(int ar[])
    {
        //step1-build max heap
        int n=ar.length;
        for(int i=n/2;i>=0;i--)//O(n log(n))
        {
            heapify(ar,i,n);
        }
        //step2-push largest at end
        for(int i=n-1;i>=0;i--)
        {
            //swap
            int temp=ar[0];
            ar[0]=ar[i];
            ar[i]=temp;
            heapify(ar,0,i);
        }
    } 
    public static void main(String[] args) {
        int ar[]={1,2,4,5,3};
        sort(ar);
        for(int i=0;i<ar.length;i++)
        System.out.print(ar[i]+" ");
    }   
}
