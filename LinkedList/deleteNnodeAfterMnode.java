import java.util.*;
public class deleteNnodeAfterMnode
{
    public class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    public void push(int d)
    {
        Node temp=head;
        Node newNode=new Node(d);
        if(temp==null)
        {
            head=newNode;
            return;
        }
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=null;

    }
    public void delete(int m,int n)
    {
        Node temp=head;
        for(int i=0;i<m-1;i++)
        {
            temp=temp.next;
        }
        Node newtemp=temp.next;
        for(int i=0;i<n;i++)
        {
            newtemp=newtemp.next;
        }
        temp.next=newtemp;
        temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String[] args) 
    {
        deleteNnodeAfterMnode obj=new deleteNnodeAfterMnode();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        int m=2,n=1;
        obj.delete(m,n);
    }
}