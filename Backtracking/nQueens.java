public class nQueens 
{
    static int c=0;
    public static void nQueensAllWays(char board[][],int row)
    {
        //base case
        if(row==board.length)
        {
            c++;
            printBoard(board);
            return;
        }
        for(int j=0;j<board.length;j++)
        {
            if(isSafe(board,row,j))
            {
                board[row][j]='Q';
                nQueensAllWays(board, row+1);//recursive call
                board[row][j]='.';//backtracking step
            }
        }
    }
    public static boolean isSafe(char board[][],int row,int col)
    {
        //vertical up
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]=='Q')
            return false;
        }
        //diagonal left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            return false;
        }
        //diagonal right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            return false;
        }
        return true;
    }
    public static void printBoard(char board[][])
    {
        System.out.println("----------");
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        int n=3;
        char board[][]=new char[n][n];
        //initializing
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            board[i][j]='.';
        }
        nQueensAllWays(board,0);
        System.out.println("Count:"+c);
    }    
}
