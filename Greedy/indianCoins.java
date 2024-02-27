import java.util.*;
public class indianCoins 
{
    public static void main(String[] args) //Minimum no.of notes
    {        
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        int counOfCoins=0;
        int amt=590;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<coins.length;i++)
        {
            if(coins[i] <= amt)
            {
                while(coins[i]<=amt)
                {
                    counOfCoins++;
                    ans.add(coins[i]);
                    amt-=coins[i];
                }
            }
        }   
        System.out.println("Count of Coins:"+counOfCoins);
        for(int i=0;i<ans.size();i++)
        System.out.println(ans.get(i)+" ");
    } 
}