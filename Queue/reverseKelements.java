import java.util.*;
class reverseKelements
{
    public static void reverse(Queue<Integer>q,int n)
    {
        int l=q.size(),no=n,d=l-no;
        Stack<Integer>s=new Stack<>();
        while(n>0)
        {
            s.push(q.remove());
            n--;
        }
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }
        while(d> 0)
        {
            q.add(q.remove());
            d--;
        }
        System.out.println(q);
    } 
    public static void main(String[] args) 
    {
        Queue <Integer>q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        reverse(q,3);
    }
}