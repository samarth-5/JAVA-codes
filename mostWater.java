import java.util.*;
public class mostWater
{
    public static int maxWater(ArrayList<Integer>height)//O(n)
    {
        int maxW=0,lp=0,rp=height.size()-1;
        while(lp<rp)
        {
            int ht=Math.min(height.get(rp),height.get(lp));
            int width=rp-lp;
            int currWater=ht*width;
            maxW=Math.max(maxW,currWater);
            if(height.get(lp)<height.get(rp))
            lp++;
            else
            rp--;
        } 
        return maxW;     
    }
    public static void main(String[] args) 
    {
        ArrayList<Integer>ht=new ArrayList<>();
        ht.add(1);
        ht.add(8);
        ht.add(6);
        ht.add(2);
        ht.add(5);
        ht.add(4);
        ht.add(8);
        ht.add(3);
        ht.add(7);
        System.out.println(maxWater(ht));
    }
}