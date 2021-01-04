package algo.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/5
 * @Description:
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 **/
public class N_Queens_51 {
    static List<List<String>>  res=new ArrayList<>();
    @Test
    public void test(){
        List<List<String>> res=solveNQueens(8);

        for (int i = 0; i < res.size(); i++) {
            List<String> list=res.get(i);
            for (int j = 0; j <list.size() ; j++) {
                System.out.println(list.get(j));
            }

            System.out.println();

        }


    }

    public List<List<String>> solveNQueens(int n) {

       char [][] board=new char[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

       backTrack(board,0);

        return res;


    }
    public void backTrack(char [][] board, int row) {
        // 触发结束条件
        if(row==board.length){
            List<String> list=new ArrayList<>();
            for (int i = 0; i <board.length ; i++) {
                String level=new String();
                for (int j = 0; j < board.length; j++) {
                    level+=board[i][j];
                }
                list.add(level);
            }
            res.add(list);
        }

        int n=board.length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if(!isValid(board,row,col)){
                continue;
            }
            // 做选择
            board[row][col]='Q';
            // 进入下一行决策
            backTrack(board,row+1);
            // 撤销选择
            board[row][col]='.';
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    public boolean isValid(char[][] board,int row,int col){
        int n=board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <n ; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row-1,j=col+1; i>=0&&j<n ; i--,j++) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for(int i=row-1,j=col-1; i >= 0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
