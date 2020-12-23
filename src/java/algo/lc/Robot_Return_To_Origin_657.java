package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/28
 * @Description:
There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:

Input: "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.


Example 2:

Input: "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.

 **/
public class Robot_Return_To_Origin_657 {
    public boolean judgeCircle(String moves) {

        int a1=0;
        int a2=0;
        for (int i = 0; i < moves.length(); i++) {
            char c=moves.charAt(i);
            if(c=='R'){
                a1+=1;
            }else if(c=='L'){
                a1-=1;
            }else if(c=='U'){
                a2+=1;
            }else if(c=='D'){
                a2-=1;
            }
        }

        if(a1==0&&a2==0){
            return true;
        }else{
            return false;
        }
    }
}
