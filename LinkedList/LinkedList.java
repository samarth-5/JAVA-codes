class LinkedList
{
    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data)
    {
        Node temp=new Node(data);
        if(head==null)
        {
            head=tail=temp;
            return;
        }
        temp.next=head;
        head=temp;
    }
    public void addLast(int data)
    {
        Node temp=new Node(data);
        if(head==null)
        {
            head=tail=temp;
            return;
        }
        tail.next=temp;
        tail=temp;
    }
    public void addMiddle(int data,int idx)
    {
        Node temp=new Node(data);
        Node itr=head;
        for(int i=1;i<idx;i++)
        {
            itr=itr.next;
        }
        temp.next=itr.next;
        itr.next=temp;
    }
    public void print()
    {
        Node itr=head;
        while(itr!=null)
        {
            System.out.print(itr.data+"->");
            itr=itr.next;
        }
        System.out.println();
    }
    public int RecursiveSearch(Node head,int key)
    {
        if(head==null)
        return -1;
        if(head.data==key)
        return 0;
        int idx=RecursiveSearch(head.next, key);
        return idx+1;
    }
    public Node middleNode(Node head)
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;//+1
            fast=fast.next.next;//++2
        }
        return slow;
    }
    public boolean palin()
    {
        if(head==null || head.next==null)
        return true;
        //finding middle node
        Node mid=middleNode(head);
        //reversing 2nd half
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr != null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev; //right half head
        Node left=head;
        //check left and right half
        while(right!=null)
        {
            if(left.data != right.data)
            return false;
            left=left.next;
            right=right.next;
        }
        return true;
    }
    private Node getMid(Node head)
    {
        Node slow=head;
        Node fast=head.next;
        while(slow!=null && fast.next!=null)
        {
            slow=head.next;
            fast=head.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2)
    {
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null)
        {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null)
        {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head)
    {
        if(head==null || head.next!=null)
        return head;
        //find mid
        Node mid=getMid();
        //left and right ms
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node right=mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }
    public static void main(String[] args) 
    {
        LinkedList ll=new LinkedList();
        ll.addFirst(5);
        ll.addFirst(9);
        ll.addFirst(7);
        ll.addLast(3);
        ll.addMiddle(1,3);
        ll.print();
        System.out.println(ll.RecursiveSearch(head, 5));
        System.out.println(ll.middleNode(head).data);
        System.out.println(ll.palin());
        ll.print();
        ll.head=ll.mergeSort(ll.head);
        ll.print();
    }
}