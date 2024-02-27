import java.util.*;
public class nextGreaterElement
{
    public static void greater(int ar[])
    {
        Stack<Integer> s=new Stack<>();
        int great[]=new int[ar.length];
        for(int i=ar.length-1;i>=0;i--)
        {
            while(!s.isEmpty() && ar[i]>=ar[s.peek()])
            {
                s.pop();
            } 
            if(s.isEmpty())
            great[i]=-1;
            else
            great[i]=ar[s.peek()];
            s.push(i);        
        }
        for(int i=0;i<great.length;i++)
        System.out.print(great[i]+" ");
    }
    public static void main(String[] args) 
    {
        int ar[]={6,8,0,1,3};
        greater(ar);
    }
}