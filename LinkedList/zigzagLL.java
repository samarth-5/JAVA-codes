import java.util.*;
class zigzagLL
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
    public static void zigzag()
    {
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        //alternate merge zig-zag merge
        Node nextL,nextR;
        while(next!=null && right!=null)
        {
            nextl=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            //updating
            left=nextL;
            right=nextR;
        }
    }
    public static void main(String[] args) 
    {}
}