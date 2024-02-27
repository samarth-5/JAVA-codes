public class mergeSortLL
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
    }
    public Node merge(Node head1,Node head2)
    {
        Node temp1=head1,temp2=head2,temp=null;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.data>temp2.data)
            { 
                if (temp == null) 
                {
                    temp = temp2;
                }
                else 
                {
                    temp.next = temp2;
                    temp = temp.next;
                }
                temp2=temp2.next;
            }
            else
            {
                if (temp == null) 
                {
                    temp = temp1;
                }
                else 
                {
                    temp.next = temp1;
                    temp = temp.next;
                }
                temp1=temp1.next;
            }
        }
        while(temp1 != null)
        {
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;
        }
        while(temp2 != null)
        {
            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
        return temp.next;
    }
    public static void main(String[] args) 
    {
        mergeSortLL list1 = new mergeSortLL();
        list1.push(10);
        list1.push(5);
        list1.push(15);
        list1.push(2);
        list1.push(20);
        mergeSortLL list2 = new mergeSortLL();
        list2.push(3);
        list2.push(8);
        list2.push(12);

        Node newTemp=list1.merge(list1.head,list2.head);
        Node curr=newTemp;
        while(curr!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }    
}