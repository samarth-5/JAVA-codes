import java.util.*;
class maxArea
{
    public static int maxAreaInHistogram(int ar[])//O(n)
    {
        int maxArea=0;
        int nsl[]=new int[ar.length];
        int nsr[]=new int[ar.length];
        //next Smaller Right
        Stack<Integer>s=new Stack<>();
        for(int i=ar.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && ar[s.peek()]>=ar[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            nsr[i]=ar.length;
            else
            nsr[i]=s.peek();
            s.push(i);
        }
        //next Smaller Left
        s=new Stack<>();
        for(int i=0;i<ar.length;i++)
        {
            while(!s.isEmpty() && ar[s.peek()]>=ar[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            nsl[i]=-1;
            else
            nsl[i]=s.peek();
            s.push(i);
        }
        //current Area
        for(int i=0;i<ar.length;i++)
        {
            int ht=ar[i];
            int area=ht*(nsr[i]-nsl[i]-1);
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String[] args) 
    {  
        int ar[]={2,1,5,6,2,3};
        System.out.println("Max Area:"+maxAreaInHistogram(ar));      
    }
}