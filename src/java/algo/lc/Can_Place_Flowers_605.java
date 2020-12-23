package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/5
 * @Description:
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.



Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false



 **/
public class Can_Place_Flowers_605 {


    @Test
    public void test(){

        int [] a={0,0,1,0,1};


        System.out.println( canPlaceFlowers(a,1));;

    }



    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i=0;

        int place=0;
        boolean edge=false;
        for (int j = 0; j < flowerbed.length; j++) {


            if(flowerbed[j]==0){
                if(j==0){
                    edge=true;
                }
                i++;
            }else{
                if(i==0){
                    continue;
                }

                if(edge){
                    place+=i/2;
                    edge=false;

                }else{
                    place+=(i-1)/2;
                }
                i=0;
            }
        }

        if(i==flowerbed.length){
            place+=(i+1)/2;
        }else if(i>0){
            place+=(i)/2;
        }


        return place>=n;

    }


}
