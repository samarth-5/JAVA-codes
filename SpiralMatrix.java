public class SpiralMatrix 
{
    public static void Spiral(int ar[][])
    {
        int startRow=0,startCol=0,endRow=ar.length-1,endCol=ar[0].length-1;
        while(startRow<=endRow && startCol<=endCol)
        {
            //top
            for(int j=startCol;j<=endCol;j++)
            System.out.print(ar[startRow][j]+" ");
            //right
            for(int i=startRow+1;i<=endRow;i++)
            System.out.print(ar[i][endCol]+" ");
            //bottom
            for(int j=endCol-1;j>=startCol;j--)
            System.out.print(ar[endRow][j]+" ");
            //left
            for(int i=endRow-1;i>=startRow+1;i--)
            System.out.print(ar[i][startCol]+" ");
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }    
    public static void main(String Args[])
    {
        int ar[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        Spiral(ar);
    }
}
