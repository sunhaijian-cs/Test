package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/17
 * @Description:
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 **/
public class Surrounded_Regions_130 {

    public void solve(char[][] board) {
        int rows=board.length;
        if(rows==0) {
            return;
        }
        int cols=board[0].length;



        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][cols-1]=='O'){
                dfs(board,i,cols-1);
            }
        }

        for(int i=0;i<cols;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[rows-1][i]=='O'){
                dfs(board,rows-1,i);
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='U'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }


    }

    public void dfs(char[][] board,int row,int col){
        if(board[row][col]=='X'||board[row][col]=='U'){
            return;
        }

        board[row][col]='U';
        int rows=board.length;
        int cols=board[0].length;

        int [] dx={0,0,-1,1};
        int [] dy={-1,1,0,0};
        for(int i=0;i<dx.length;i++){
            int nx=row+dx[i];
            int ny=col+dy[i];
            if(nx>=0&&nx<rows&&ny>=0&&ny<cols){
                dfs(board,nx,ny);
            }
        }
    }

}
