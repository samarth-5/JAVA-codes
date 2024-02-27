import java.util.*;
public class search
{
    //kth smallest element in unsorted array O(n)
    void medianSearch(ArrayList<Integer> ar,int k)    
    {
        int a=ar.get(0);
        ArrayList <Integer>s1=new ArrayList<>();
        ArrayList <Integer>s2=new ArrayList<>();
        ArrayList <Integer>s3=new ArrayList<>();      
        for(int i=0;i<ar.size();i++)
        {
            if(ar.get(i)<a)
            s1.add(ar.get(i));
            else if(ar.get(i)==a)
            s2.add(ar.get(i));
            else
            s3.add(ar.get(i));
        }  
        if(s1.size()>=k)
        medianSearch(s1, k);
        else if(s1.size()+s2.size()==k)
        System.out.println(a);
        else
        medianSearch(s3, k-s1.size()-s2.size());
    }
    public static void main(String[] args)
    {
        search obj=new search();
        ArrayList<Integer> ar=new ArrayList<>();
        ar.add(5);
        ar.add(10);
        ar.add(19);
        ar.add(2);
        ar.add(6);
        ar.add(7);
        ar.add(15);
        obj.medianSearch(ar,5);
    }
}
