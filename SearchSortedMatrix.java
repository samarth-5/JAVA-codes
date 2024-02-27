public class SearchSortedMatrix
{
    public static boolean StaircaseSort(int ar[][],int key)//O(n+m)
    {
        int row=0,col=ar[0].length-1;
        while(row<ar.length && col>=0)
        {
            if(ar[row][col]==key)
            {
                System.out.println("Key found in "+row+" row and "+col+" coloumn.");
                return true;
            }
            else if(key<ar[row][col])
            col--;
            else if(key>ar[row][col])
            row++;
        }
        System.out.println("Key not found !!");
        return false;
    }
    public static void main(String Args[])
    {
        int ar[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key=33;
        StaircaseSort(ar,key);
    }
}