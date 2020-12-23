package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/17
 * @Description:
 **/
public class Sudoku_Solver_37 {

    static char [][] res;
    @Test
    public void test(){
        char [][]board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
//        System.out.println(JSON.toJSONString(board));

    }

    public void solveSudoku1(char[][] board) {
        backtrack(board,0,0);
    }


    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != '.') {
            // 如果有预设数字，不用我们穷举
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) {
                return false;
            }
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }












//    ---------------自己的解法，还有问题------------
    public void solveSudoku(char[][] board) {
        backTrack(board,0,0);
    }

    public void backTrack(char board[][],int startx,int starty){
        if(isFinished(board)){
            System.out.println(JSON.toJSONString(board));
        }




        for(int i=startx;i<9;i++){
            for(int j=starty;j<9;j++){
                if(board[i][j]!='.'){
                    continue;
                }
                for(int k=1;k<9;k++){
                    if(isValid(board,i,j,k)){
                        board[i][j]=(char)(k+'0');
                        backTrack(board,i,j);
                        board[i][j]='.';
                    }
                }
            }
        }
    }

    public boolean  isValid(char board[][],int x,int y,int k){
        for(int i=0;i<9;i++){
            if(i==x){continue;}
            if(board[i][y]==(char)(k+'0')){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(i==y){continue;}
            if(board[x][i]==(char)(k+'0')){
                return false;
            }
        }
        return true;
    }

    public boolean  isFinished(char board[][]){
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    return false;
                }
            }

        }
        return true;
    }
}
