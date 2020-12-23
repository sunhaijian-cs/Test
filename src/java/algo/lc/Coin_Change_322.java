package algo.lc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunhaijian
 * @Date: 2020/9/25
 * @Description:
 *
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.You may assume that you have an infinite number of each kind of coin.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)
Example 2:
coins = [2], amount = 3
return -1.
 **/
public class Coin_Change_322 {

    @Test
    public void test(){
//        int[] coins={1, 2, 5};
//        int amount=11;

//        int[] coins={2};
//        int amount=3;
//
       int[] coins={186,419,83,408};
       int amount=6249;
//        System.out.println(coinChange3(coins, amount, new int[amount]));
        System.out.println(coinChange2(coins, amount, new int[amount+1]));


    }


    /**
     * 暴力递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        int res=Integer.MAX_VALUE;
        for (int coin:coins) {
            int subres=coinChange(coins, amount-coin);
            if(subres==-1){
                continue;
            }
            res=Math.min(subres+1,res);
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    /**
     * 加上备忘录  超时，因为少了-1的备忘录
     * @param coins
     * @param amount
     * @return
     */
    Map<Integer,Integer> map=new HashMap();

    public int coinChange1(int[] coins, int amount) {

        if(map.get(amount)!=null){
            return map.get(amount);
        }

        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }


        int res=Integer.MAX_VALUE;
        for (int coin:coins) {
            int subres=coinChange1(coins, amount-coin);
            if(subres==-1){
                continue;
            }
            res=Math.min(subres+1,res);
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        map.put(amount,res);
        return res;
    }


    /**
     * 加上备忘录
     * @param coins
     * @param amount
     * @return
     */

    public int coinChange2(int[] coins, int amount, int [] count) {

        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if (count[amount] != 0) {
            return count[amount];
        }
        int res=Integer.MAX_VALUE;
        for (int coin:coins) {
            int subres=coinChange2(coins, amount-coin,count);

            if(subres>=0&&subres<res){
                res =subres+1;
            }
//            res=Math.min(subres+1,res);
//            res=Math.min(subres+1,res);

        }
        if(res==Integer.MAX_VALUE){

            /**
             * 下面这一行居然是核心点，牛逼了。没有下面这一行就会超时。
             */
            count[amount]=-1;
            return -1;
        }
        count[amount]=res;

        return  count[amount];
    }


    /**
     * 官方答案
     * @param coins
     * @param rem
     * @param count
     * @return
     */

    private int coinChange3(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange3(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

}
