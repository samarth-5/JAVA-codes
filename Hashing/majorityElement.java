import java.util.*;
class majorityElement
{
    public static void main(String[] args) 
    {
        int ar[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<ar.length;i++)
        {
            //if(hm.containsKey(ar[i]))
            //{
            //    hm.put(ar[i],hm.get(ar[i])+1);
            //}
            //else
            //{
            //    hm.put(ar[i],1);
            //}
            hm.put(ar[i],hm.getOrDefault(ar[i], 0)+1);
        }
        Set<Integer> keySet=hm.keySet();
        for(Integer k:keySet)
        {
            if(hm.get(k)>ar.length/3)
            System.out.println(k);
        }
    }
}