package algo.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/24
 * @Description:
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

 **/

@RunWith(Parameterized.class)
public class Shuffle_An_Array_384 {

    private int [] array;
    private int[] originNum;

    Random rand=new Random();

//    public Shuffle_An_Array_384 (){ }

    public Shuffle_An_Array_384(int[] nums) {
        array=nums;
        originNum=nums.clone();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array=originNum;
        originNum=originNum.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            swap(i,rand(i,array.length));
        }
        return array;
    }

    private int rand(int min,int max){
        return rand.nextInt(max-min)+min;
    }

    private void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
//
//    @Test
//     void test(){
//
//        check();
//        System.out.println(1);
//    }

    public static void main(String[] args) {
        check2();
//        System.out.println(1);
    }


    public static void check(){
        int N=1000000;
        Map<String,Integer> map=new HashMap();
        map.put("123",0);
        map.put("132",0);
        map.put("321",0);
        map.put("312",0);
        map.put("213",0);
        map.put("231",0);

        for (int i = 0; i < N; i++) {
            int [] arr={1,2,3};

            Shuffle_An_Array_384 shuf=new Shuffle_An_Array_384(arr);
            int []res=shuf.shuffle();
            String str=""+res[0]+res[1]+res[2];
            map.put(str,map.get(str)+1);
        }
        for (String key:map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
    }
    public static void check2(){
        int N=1000000;

        int []count=new int [5];

        for (int i = 0; i < N; i++) {
            int [] arr={1,0,0,0,0};

            Shuffle_An_Array_384 shuf=new Shuffle_An_Array_384(arr);
            int []res=shuf.shuffle();
            for (int j = 0; j <res.length ; j++) {
                if(res[j]==1){
                    count[j]++;
                }
            }
        }
        for (int i = 0; i <count.length ; i++) {
            System.out.println(i+":"+count[i]);
        }
    }

}
