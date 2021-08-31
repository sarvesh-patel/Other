//import java.util.*;
public class sudoku {
    public static void display(int board[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {System.out.print(board[i][j]+" ");}
         System.out.println(" ");
        }
    }
    public static boolean issafe(int board[][],int i, int j, int k)
    {   if(board[i][j]!=0)
        {return false;}
        else{
            for(int m=0;m<9;m++)  // For entire row and column
            {
                if(board[i][m]== k || board[m][j] == k)
                {return false;}
            }
            // now to look inside box
            i=(i/3)*3; j=(j/3)*3;
            for(int a=0;a<3;a++)
            {
                for(int b=0; b<3;b++ )
                {
                    if(board[i+a][j+b]==k){return false;}
                   
                    
                }
            }
        }
     return true;
    }
 public static void run(int board[][],int i,int j)
 {  if(i==board.length-1 && j==board[0].length)
     { display(board); 
        return;
     }
     if(j==9)
    {
        i=i+1; j=0;
    }
    
     if(board[i][j]!=0)
    {run(board,i,j+1);}
   else
    {
        for(int k=1;k<=9;k++)
        { if(issafe(board,i,j,k))
            {board[i][j]=k;
            run(board,i,j+1);
            board[i][j]=0; // WHY
            }

        }
    }

 }

    public static void main(String[] args) throws Exception {
        int board[][]= { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
                         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        //sudoku s = new sudoku();
        run(board, 0, 0);
        


    }
}
