import java.util.*;
class generateBinaryNumbers
{
    public static void bin(int n)//Generate n binary numbers
    {
        Queue <String>q=new LinkedList<String>();
        q.add("1");
        while(n>0)
        {
            String s=q.peek();
            System.out.print(s+" ");
            n--;
            String s1=q.remove();
            q.add(s1+"0");
            q.add(s1+"1");
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a no:");
        int n=sc.nextInt();
        bin(n);
    }
}