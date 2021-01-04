package algo.lc;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: sunhaijian
 * @Date: 2020/11/30
 * @Description:
 **/
public class Reorganize_String_767 {


    @Test
    public  void test() {
        System.out.println(reorganizeString("aab"));
    }


    public String reorganizeString(String S) {
        if(S.length()<2){
            return S;
        }
        int []counts =new int[26];
        int maxCount=0;

        for (char s:S.toCharArray()) {
            counts[s-'a']++;
            maxCount=Math.max(maxCount, counts[s-'a']);
        }

        if(maxCount>(S.length()+1)/2){
            return "";
        }

        PriorityQueue<Character> priorityQueue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2-'a']-counts[o1-'a'];
            }
        });

        for (int i = 0; i <26 ; i++) {
            if(counts[i]!=0){
                priorityQueue.offer((char)('a'+i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while(priorityQueue.size()>1){
            char c1=priorityQueue.poll();
            char c2= priorityQueue.poll();
            counts[c1-'a']--;
            counts[c2-'a']--;
            sb.append(c1);
            sb.append(c2);

            if(counts[c1-'a']>0) {
                priorityQueue.offer(c1);
            }
            if(counts[c2-'a']>0) {
                priorityQueue.offer(c2);
            }

        }
        if(priorityQueue.size()>0){
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }
}
