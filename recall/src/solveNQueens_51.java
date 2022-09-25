import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solveNQueens_51 {
    ArrayList<List<String>> list=new ArrayList<List<String>>();
    LinkedList<String> node=new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean CheckerBoard[][]=new boolean[n][n];
        recall(n,0,CheckerBoard);
        return list;
    }
    public boolean isVa(boolean chessboard[][],int n,int row,int col)
    {
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col]) {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] ) {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] ) {
                return false;
            }
        }
        return true;
    }
    public void recall(int n,int index,boolean CheckerBoard[][])
    {
        if(node.size()==n)
        {
            list.add(new LinkedList<>(node));
            return;
        }
        for(int i=0;i<n;i++)
        {
            char[]ch=new char[n];
            for(int j=0;j<n;j++)
            {
                ch[j]='.';
            }
            CheckerBoard[index][i]=true;
            if(isVa(CheckerBoard,n,index,i))
            {
                ch[i]='Q';
                node.add(new String(ch));
                recall(n,index+1,CheckerBoard);
                node.removeLast();
            }
            CheckerBoard[index][i]=false;
        }
    }


    @Test
    public void test(){
        StringBuilder str=new StringBuilder();
        for(int j=0;j<1;j++)
        {
            str.append('.');
        }
        str.append('Q');
        for(int j=1;j<4-1;j++)
        {
            str.append('.');
        }
        System.out.println(str.toString());
    }
}
