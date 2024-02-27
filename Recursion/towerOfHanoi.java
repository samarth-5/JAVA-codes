public class towerOfHanoi 
{
    public static void toh(int n,char src,char dest,char help)
    {
        if(n==1)
        {
            System.out.println("Move disk"+n+" from "+src+" to "+dest);
            return;
        }
        toh(n-1,src,help,dest);
        System.out.println("Move disk"+n+" from "+src+" to "+dest);
        toh(n-1,help,dest,src);
    }
    public static void main(String[] args) 
    {
        int n=6;
        toh(n,'A','C','B');
    }    
}