package algo.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/13
 * @Description:
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.


Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false


Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
 **/
public class Iterator_For_Combination_1286 {

        List<String> list=new ArrayList();
        int count=0;
        public Iterator_For_Combination_1286(String characters, int combinationLength) {
            traceback(characters,combinationLength,"",0);

        }

        public String next() {
            return list.get(count++);

        }

        public boolean hasNext() {
            if(count==list.size()){
                return false;
            }else {
                return true;
            }
        }

        public void  traceback(String characters, int combinationLength,String result,int index){
            if(result.length()==combinationLength){
                list.add(result);
                return;
            }
            if(result.length()+(characters.length()-index)<combinationLength){
                return;
            }
            for(int i=index;i<characters.length();i++){
                traceback(characters,combinationLength,result+characters.charAt(i),i+1);
            }

        }

    public static void main(String[] args) {
        Iterator_For_Combination_1286 it=new Iterator_For_Combination_1286("abc",2);
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());




    }



/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

}
