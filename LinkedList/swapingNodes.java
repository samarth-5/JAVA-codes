public class swapingNodes 
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
    public void swap(int x,int y)
    {
        Node temp1=head,temp2=head;
        for(int i=0;i<x-1;i++)
        {
            temp1=temp1.next;
        }
        int d=temp1.data;
        for(int i=0;i<y-1;i++)
        {
            temp2=temp2.next;
        }
        temp1.data=temp2.data;
        temp2.data=d;
        //printing
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
    public static void main(String[] args) 
    {
        swapingNodes obj=new swapingNodes();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        int x=2,y=4;
        obj.swap(x,y);
    }    
}
