public class tiling
{
    public static int tile(int n)//2xn(floor size)
    {
        if(n==0 || n==1)
        return 1;
        int verticalTiles=tile(n-1);//vertical choice
        int horizontalTiles=tile(n-2);
        int totalWays=verticalTiles+horizontalTiles;
        return totalWays;
    }
    public static void main(String Args[])
    {
        System.out.println(tile(2));
    }
}