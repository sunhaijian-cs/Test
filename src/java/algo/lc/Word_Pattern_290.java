package algo.lc;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: sunhaijian
 * @Date: 2020/4/23
 * @Description:
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
说明：你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
示例1：
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例2：
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例3：
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例4：
输入: pattern = "abba", str = "dog dog dog dog"
输出: false

 **/
public class Word_Pattern_290 {

    @Test
    public void test(){
        String pattern ="aaaa";
        String str="dog cat cat dog";

        System.out.println(wordPattern(pattern,str));

    }

    public boolean wordPattern(String pattern,String str){

        String [] strArr=str.split(" ");
        HashSet set=new HashSet();
        HashMap<Character,String> map=new HashMap<>();

        char [] chars=pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                if(map.get(chars[i]).equals(strArr[i])){
                    continue;
                }else{
                    return false;
                }


            }else{
                if(set.contains(strArr[i])){
                    return false;
                }
                map.put(chars[i],strArr[i]);
                set.add(strArr[i]);
            }

        }
        return true;
    }
}
