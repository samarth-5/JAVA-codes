public class TrappingRainWater 
{
    public static void Trap(int ar[])
    {
        int lmb[]=new int[ar.length],rmb[]=new int[ar.length];
        lmb[0]=ar[0];
        rmb[ar.length-1]=ar[ar.length-1];
        for(int i=1;i<ar.length;i++)
        {
            lmb[i]=Math.max(ar[i],lmb[i-1]);
            
        }
        for(int i=ar.length-2;i>=0;i--)
        {
            rmb[i]=Math.max(ar[i],rmb[i+1]);
        }
        int tw=0;
        for(int i=0;i<ar.length;i++)
        {
            tw=tw+Math.min(lmb[i],rmb[i])-ar[i];
        }
        System.out.println(tw);
    }    
    public static void main(String Args[])
    {
        int ar[]={4,2,0,6,3,2,5};
        Trap(ar);
    }
}
