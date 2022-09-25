import org.junit.Test;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 */
public class solveSudoku_37 {
    public void solveSudoku(char[][] board) {
        recall(board,0,0);
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public boolean recall(char[][]board,int Y,int X)
    {
        for(int i=Y;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if(board[i][j]!='.') continue;
                for(char k='1';k<='9' ;k++)
                {
                    if(isValid(i,j,board,k))
                    {
                        board[i][j]=k;
                        if(recall(board,i,j+1))
                        {
                            return true;
                        }
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    public boolean isValid(int row,int col,char[][]board,char val)
    {
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void test()
    {
        char [][]tem=new char[][]
                {//       1   2   3     4   5   6   7   8   9
                        {'.','.','.',  '9','5','.',  '.','.','.'},//1
                        {'.','.','1',  '.','4','.',  '3','.','.'},//2
                        {'2','9','.',  '.','.','.',  '7','.','.'},//3

                        {'.','.','.',  '.','.','3',  '.','5','7'},//4
                        {'.','.','.',  '.','.','5',  '9','3','.'},//5
                        {'.','7','3',  '1','.','.',  '.','.','2'},//6

                        {'3','.','.',  '6','1','.',  '.','.','.'},//7
                        {'.','.','4',  '.','.','.',  '8','.','3'},//8
                        {'6','.','2',  '3','.','.',  '.','.','.'},//9
                };
        solveSudoku(tem);
    }
}
