//allowed moves- down or right
public class gridWays//2^(n+m)
{
    public static int grid(int i,int j,int m,int n)
    {
        if(i==n-1 && j==m-1)//last cell
        return 1;
        else if(i==n || j==m)//boundary cndn
        return 0;
        int way1=grid(i+1, j, m, n);
        int way2=grid(i, j+1, m, n);
        return  way1+way2;
    }
    public static void main(String[] args)
    {
        int m=3,n=3;
        System.out.println(grid(0, 0, m, m));
    }
}
//use the factorial method to get linear time complexity 
//take out no. of permutations
//tot ways = (n-1+m-1)!  /  (n-1)!(m-1)!