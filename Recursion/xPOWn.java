class xPOWn //O(log n)
{
    public static int power(int x,int n)
    {
        if(n==1)
        return x;
        int halfPower=power(x,n/2);
        if(n%2!=0)
        return x*halfPower*halfPower;

        return halfPower*halfPower;
    }
    public static void main(String Args[])
    {
        int x=2,n=5;        
        System.out.println(power(x,n));
    }    
}
