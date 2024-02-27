import java.util.*;
public class heap
{
    static class heapDS
    {
        ArrayList<Integer>ar=new ArrayList<>();
        public void add(int data)//For min heap
        {
            //add at last idx
            ar.add(data);
            int x=ar.size()-1;
            int par=(x-1)/2;
            while(ar.get(x)<ar.get(par))//O(log n)
            {
                //swap
                int temp=ar.get(x);
                ar.set(x,ar.get(par));
                ar.set(par,temp);
                x=par;
                par=(x-1)/2;
            }
        }
        public int peek()
        {
            return ar.get(0);
        }
        public int remove()
        {
            int data=ar.get(0);
            //step1-swap first and last
            int temp=ar.get(0);
            ar.set(0,ar.get(ar.size()-1));
            ar.set(ar.size()-1,temp);
            //step2-delete last
            ar.remove(ar.size()-1);
            //step3-heapify
            heapify(0);
            return data;
        }
        private void heapify(int i)//T.C. -> log(n)
        {
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            if(left<ar.size() && ar.get(minIdx)>ar.get(left))
            minIdx=left;
            if(right<ar.size() && ar.get(minIdx)>ar.get(right))
            minIdx=right;

            if(minIdx != i)
            {
                //swap
                int temp=ar.get(minIdx);
                ar.set(minIdx,ar.get(i));
                ar.set(i,temp);
                heapify(minIdx);
            }
        }
        public boolean isEmpty()
        {
            return ar.size()==0;
        }
    }
    public static void main(String[] args) 
    {
        heapDS pq=new heapDS();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);
        while(!pq.isEmpty())//Heap Sort -> T.C.-n(log(n))
        {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}