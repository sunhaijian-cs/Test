package algo.lc;

import org.junit.Test;

import java.util.*;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/12
 * @Description:
 **/
public class Insert_Delete_GetRandom_O1_380 {
    @Test
    public void test(){
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());





//
//        boolean param_1 = obj.insert(val);
//        boolean param_2 = obj.remove(val);
//        int param_3 = obj.getRandom();
    }
}

class RandomizedSet {
    Map<Integer,Integer> numMap;
    List<Integer> numList;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        numMap=new HashMap();
        numList=new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numMap.containsKey(val)){
            return false;
        }

        numList.add(val);
        numMap.put(val,numList.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!numMap.containsKey(val)){
            return false;
        }

        int lastVal=numList.get(numList.size()-1);
        numList.set(numMap.get(val),lastVal);
        numList.remove(numList.size()-1);

        // numMap.remove(lastVal);
        int index=numMap.get(val);
        numMap.put(lastVal,index);
        numMap.remove(val);

        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(numList.size()==0){
            return 0;
        }
        return numList.get(new Random().nextInt(numList.size()));
    }
}
