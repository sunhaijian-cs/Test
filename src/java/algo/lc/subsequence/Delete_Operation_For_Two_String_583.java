package algo.lc.subsequence;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/7
 * @Description:

 *Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
 **/
public class Delete_Operation_For_Two_String_583 {

    int dp[][];

    public int minDistance(String word1, String word2) {

        if(word1.equals(word2)){
            return 0;
        }

        dp=new int[word1.length()][word2.length()];
        return dp(word1,0,word2,0);
    }

    public int dp(String word1,int i, String word2,int j){

        if(i==word1.length()){
           return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }


        if(dp[i][j]>0){
            return dp[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]= dp( word1, i+1,  word2, j+1);
        }else{

            dp[i][j]= Math.min( dp( word1, i,  word2, j+1), dp( word1, i+1,  word2, j))+1;
        }
        return dp[i][j];
    }





    public int minDistance2(String word1, String word2) {

        if(word1.equals(word2)){
            return 0;
        }

        if(word1.length()==0){
            return word2.length();
        }

        if(word2.length()==0){
            return word1.length();
        }

        int [][] dp=new int[word1.length()][word2.length()];

        for (int i = 0; i <word1.length() ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <word2.length() ; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <word1.length() ; i++) {
            for (int j = 1; j <word2.length() ; j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j]);
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+1;
                }
            }

        }
        return dp[word1.length()-1][word2.length()-1];
    }
}
