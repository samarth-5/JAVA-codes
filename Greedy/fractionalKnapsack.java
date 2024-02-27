import java.util.*;
public class fractionalKnapsack 
{    
    public static void main(String[] args) 
    {        
        int val[]={60,100,120};
        int wt[]={10,20,30};
        int w=50;
        //ratio->   value/weight    
        //sort ratio in descending order
        double ratio[][]=new double[val.length][2];
        for(int i=0;i<val.length;i++)
        {
            ratio[i][0]=i;
            ratio[i][1]=val[i]/wt[i];
        }
        //ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=w;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--)
        {
            int idx=(int)ratio[i][0];
            if(capacity >= wt[idx])//include full item
            {
                finalVal+=val[idx];
                capacity-=wt[idx];
            }
            else//include fractional part
            {
                finalVal+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("Maximum Value:"+finalVal);
    }
}
