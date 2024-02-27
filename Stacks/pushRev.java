import java.util.*;
public class pushRev
{
    public static void pushAtBottom(Stack<Integer>s,int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    // public static void main(String[] args)
    // {
    //     Stack<Integer>s=new Stack<>();
    //     s.push(1);
    //     s.push(2);
    //     s.push(3);
    //     pushAtBottom(s,4);
    //     System.out.println(s);
    // }

    // public static String reverseString(String str)
    // {
    //     Stack<Character> s=new Stack();
    //     int idx=0;
    //     while(idx<str.length())
    //     {
    //         s.push(str.charAt(idx));
    //         idx++;
    //     }
    //     StringBuilder newStr=new StringBuilder("");
    //     while(!s.isEmpty())
    //     {
    //         newStr.append(s.pop());
    //     }
    //     return newStr.toString();
    // }
    // public static void main(String[] args) 
    // {
    //     String s="Abc";
    //     System.out.println(reverseString(s));
    // }

    public static void reverseStack(Stack<Integer>s)
    {
        if(s.isEmpty())
        {
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
        
    }
    public static void main(String[] args) 
    {
        Stack<Integer>s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }
}