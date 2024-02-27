public class bitManipulation 
{
    public static void oddOrEven(int n)
    {
        int bitMask=1;
        if((n & bitMask)==0)
        System.out.println("Even no.");
        else
        System.out.println("Odd no.");
    }
    public static int getIthBit(int n,int i)
    {
        int bitMask=1<<i;
        if((n & bitMask)==0)
        return 0;
        else
        return 1;
    }
    public static int setIthBit(int n,int i)
    {
        int bitMask=1<<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n,int i)
    {
        int bitMask= ~(1<<i);
        return n & bitMask;
    }
    public static int updateBit(int n,int i,int newBit)
    {
        if(newBit==0)
        return clearIthBit(n,i);
        else
        return setIthBit(n,i);
    }
    public static int clearLastIthBits(int n,int i)
    {
        int bitMask=(~0)<<i;
        return n&bitMask;
    }
    public static int rangeOfBits(int n,int i,int j)
    {
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitMask=a|b;
        return n&bitMask;
    }
    public static int countSetBist(int n)
    {
        int c=0;
        while(n>0)
        {
            if((n&1)==1)
            c++;
            n=n>>1;
        }
        return c;
    }
    public static int fastExpo(int a,int n)
    {
        int ans=1;
        while(n>0)
        {
            if((n&1) !=0)
            {
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExpo(3,5));
    }
}
