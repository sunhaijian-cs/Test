package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/8
 * @Description:
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

示例 :

输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
4     0 1 0 0
14    1 1 1 0
2     0 0 1 0
HammingDistance(4, 14) = 1 0 1 0
HammingDistance(4, 2)  = 0 1 1 0
HammingDistance(14, 2) = 1 1 0 0

第一列：0 1 0 ==> 1 * (3 -1) =  2 = 1 0 1
第二列：1 1 0 ==>  2 * (3 -2) =  2 = 0 1 1
第三列同第二列
第四列：0 0 0 ==>  0 * (3 -0) =  0 = 0 0 0

总结 ：每一列求距离产生1的个数 = 本列 1 的个数 * （数字个数 – 本列1的个数）= 本列 1 的个数 * 本列 0 的个数


 **/
public class Total_Hamming_Distance_477 {
    public static void main(String[] args) {
        int [] num={4, 14, 2};
        int total =totalHammingDistance(num);

        System.out.println(total);

    }

    private static int totalHammingDistance(int[] num) {
        int len=num.length;
        int [] bitCount=new int[32];

        if(len<2){
            return 0;
        }
        for (int i = 0; i <num.length ; i++) {
            for (int j = 0; j < bitCount.length; j++) {
                bitCount[j]+=num[i]&1;
                num[i]=num[i]>>1;
                if(num[i]==0){
                    break;
                }
            }
        }

        int total=0;
        for (int i = 0; i <bitCount.length ; i++) {
            total=total+bitCount[i]*(len-bitCount[i]);
        }
        return total;

    }

}
