import java.util.*;

import javax.print.DocFlavor.INPUT_STREAM;
public class subarraySum0 
{
    public static void main(String[] args) {
        int ar[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map=new HashMap<>();
        //(sum,idx)
        int sum=0;
        int len=0;
        for(int j=0;j<ar.length;j++)
        {
            sum+=ar[j];
            if(map.containsKey(sum))
            {
                len=Math.max(len,j-map.get(sum));
            }else
            {
                map.put(sum,j);
            }
        }
        System.out.println("Largest Subarray Sum with sum 0: "+len);
    }    
}