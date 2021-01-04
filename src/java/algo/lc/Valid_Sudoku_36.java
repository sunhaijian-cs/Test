package algo.lc;

import java.util.*;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/7
 * @Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
示例 1:

输入:
[
["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]
]
输出: true

 *
 *
 **/
public class Valid_Sudoku_36 {


    public static void main(String[] args) {

        char[][] strs = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'} };
        boolean flag = isValidSudoku(strs);
        System.out.println(flag);

    }

    private static boolean isValidSudoku(char[][] strs) {
        Map<Integer,Set<Character>> row= new HashMap();
        Map<Integer,Set<Character>> column= new HashMap();
        Map<Integer,Set<Character>> box= new HashMap();

//        box.getOrDefault()

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(strs[i][j]=='.'){
                    continue;
                }

                if (Objects.nonNull(row.get(i))){
                    Set set=row.get(i);
                    if(set.contains(strs[i][j])){
                        return false;
                    }else{
                        set.add(strs[i][j]);
                        row.put(i,set);
                    }

                }else{
                    Set<Character> set=new HashSet<>();
                    set.add(strs[i][j]);
                    row.put(i,set);
                }



                if (Objects.nonNull(column.get(j))){
                    Set set=column.get(j);
                    if(set.contains(strs[i][j])){
                        return false;
                    }else{
                        set.add(strs[i][j]);
                        column.put(j,set);
                    }

                }else{
                    Set<Character> set=new HashSet<>();
                    set.add(strs[i][j]);
                    column.put(j,set);
                }



                if (Objects.nonNull(box.get(getBoxMapId(i,j)))){
                    Set set=box.get(getBoxMapId(i,j));
                    if(set.contains(strs[i][j])){
                        return false;
                    }else{
                        set.add(strs[i][j]);
                        box.put(getBoxMapId(i,j),set);
                    }

                }else{
                    Set<Character> set=new HashSet<>();
                    set.add(strs[i][j]);
                    box.put(getBoxMapId(i,j),set);
                }
            }
        }

        return true;
    }


    public static Integer getBoxMapId(int i ,int j){

        return  i/3*3+j/3;
//
//        i+=1;
//        j+=1;
//
//
//        if(i<=3){
//            i=0;
//        }else{
//            i/=3;
//        }
//        if(j<=3){
//            j=0;
//        }else{
//            j/=3;
//        }
//        return i*10+j;
    }

}
