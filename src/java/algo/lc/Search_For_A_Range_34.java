package algo.lc;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/7
 * @Description:
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。
示例:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]


 调查二分查找mid的计算公式问题。


下面我来把所有情况都讨论一下。

寻找target在数组里的左右边界，有如下三种情况：

情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
这三种情况都考虑到，说明就想的很清楚了。

接下来，在去寻找左边界，和右边界了。

采用二分法来取寻找左右边界，为了让代码清晰，我分别写两个二分来寻找左边界和右边界。

刚刚接触二分搜索的同学不建议上来就像如果用一个二分来查找左右边界，很容易把自己绕进去，建议扎扎实实的写两个二分分别找左边界和右边界

寻找右边界
先来寻找右边界，至于二分查找，如果看过为什么每次遇到二分法，都是一看就会，一写就废就会知道，二分查找中什么时候用while (left <= right)，有什么时候用while (left < right)，其实只要清楚循环不变量，很容易区分两种写法。

那么这里我采用while (left <= right)的写法，区间定义为[left, right]，即左闭又闭的区间（如果这里有点看不懂了，强烈建议把为什么每次遇到二分法，都是一看就会，一写就废这篇文章先看了，在把「leetcode：35.搜索插入位置」做了之后在做这道题目就好很多了）

确定好：计算出来的右边界是不包好target的右边界，左边界同理。

可以写出如下代码


// 二分查找，寻找target的右边界（不包括target）
// 如果rightBorder为没有被赋值（即target在数组范围的左边，例如数组[3,3]，target为2），为了处理情况一
int getRightBorder(vector<int>& nums, int target) {
int left = 0;
int right = nums.size() - 1; // 定义target在左闭右闭的区间里，[left, right]
int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
while (left <= right) { // 当left==right，区间[left, right]依然有效
int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
if (nums[middle] > target) {
right = middle - 1; // target 在左区间，所以[left, middle - 1]
} else { // 当nums[middle] == target的时候，更新left，这样才能得到target的右边界
left = middle + 1;
rightBorder = left;
}
}
return rightBorder;
}
寻找左边界

// 二分查找，寻找target的左边界leftBorder（不包括target）
// 如果leftBorder没有被赋值（即target在数组范围的右边，例如数组[3,3],target为4），为了处理情况一
int getLeftBorder(vector<int>& nums, int target) {
int left = 0;
int right = nums.size() - 1; // 定义target在左闭右闭的区间里，[left, right]
int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
while (left <= right) {
int middle = left + ((right - left) / 2);
if (nums[middle] >= target) { // 寻找左边界，就要在nums[middle] == target的时候更新right
right = middle - 1;
leftBorder = right;
} else {
left = middle + 1;
}
}
return leftBorder;
}
处理三种情况
左右边界计算完之后，看一下主体代码，这里把上面讨论的三种情况，都覆盖了


class Solution {
public:
vector<int> searchRange(vector<int>& nums, int target) {
int leftBorder = getLeftBorder(nums, target);
int rightBorder = getRightBorder(nums, target);
// 情况一
if (leftBorder == -2 || rightBorder == -2) return {-1, -1};
// 情况三
if (rightBorder - leftBorder > 1) return {leftBorder + 1, rightBorder - 1};
// 情况二
return {-1, -1};
}
private:
int getRightBorder(vector<int>& nums, int target) {
int left = 0;
int right = nums.size() - 1;
int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
while (left <= right) {
int middle = left + ((right - left) / 2);
if (nums[middle] > target) {
right = middle - 1;
} else { // 寻找右边界，nums[middle] == target的时候更新left
left = middle + 1;
rightBorder = left;
}
}
return rightBorder;
}
int getLeftBorder(vector<int>& nums, int target) {
int left = 0;
int right = nums.size() - 1;
int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
while (left <= right) {
int middle = left + ((right - left) / 2);
if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
right = middle - 1;
leftBorder = right;
} else {
left = middle + 1;
}
}
return leftBorder;
}
};


这份代码在简洁性很有大的优化空间，例如把寻找左右区间函数合并一起。

但拆开更清晰一些，而且把三种情况以及对应的处理逻辑完整的展现出来了。

总结
初学者建议大家一块一块的去分拆这道题目，正如本题解描述，想清楚三种情况之后，先专注于寻找右区间，然后专注于寻找左区间，最后根据左右区间做最后判断。

不要上来就想如果一起寻找左右区间，搞着搞着就会顾此失彼，绕进去拔不出来了。

如果感觉题解对你有帮助，不要吝啬给一个👍吧！

作者：carlsun-2
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/34po-shi-wu-hua-de-er-fen-cha-zhao-zan-men-yi-bu-y/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 **/
public class Search_For_A_Range_34 {

    @Test
    public  void main() {
//        int []nums = {5,7,7,8,8,10};
        int []nums = {2,2};

        int target=3;

        int [] result=searchRange(nums,target);
        System.out.println(JSONObject.toJSONString(result));



    }

    public  int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            return new int[] { -1, -1 };
        }

        int left=0;
        int right=nums.length-1;

        int l=left;
        int r=right;
        int leftBorder = -2;

        while (left<=right){
            int mid=(right-left)/2+left;
            System.out.println("mid="+mid);
            System.out.println("mid2="+((right+left)/2+1));
            if(nums[mid]<target){
                left=mid+1;

            }else{
                right=mid-1;
                leftBorder=right;
            }
        }


        int rightBorder = -2;
        while (l<=r){
            int mid=(r-l)/2+l;
            System.out.println("mid="+mid);
            System.out.println("mid2="+((r+l)/2+1));
            if(nums[mid]<=target){
                l=mid+1;
                rightBorder=l;
            }else{
                r=mid-1;
            }
        }

        if(leftBorder==-2||rightBorder==-2){
            return new  int [] {-1,-1};
        }

        if(rightBorder-leftBorder>1){
            return new int []{leftBorder+1,rightBorder-1};

        }else{
            return new  int [] {-1,-1};
        }

    }


    public  int[] searchRange2(int[] nums, int target) {

        if(nums.length==0){
            return new int[] { -1, -1 };
        }

        int left=0;
        int right=nums.length-1;

        int l=left;
        int r=right;
        int leftBorder = -2;

        while (left<=right){
            int mid=(right-left)/2+left;
            System.out.println("mid="+mid);
            System.out.println("mid2="+((right+left)/2+1));
            if(nums[mid]<target){
                left=mid+1;

            }else{
                right=mid-1;
                leftBorder=right;
            }
        }


        int rightBorder = -2;
        while (l<=r){
            int mid=(r-l)/2+l;
            System.out.println("mid="+mid);
            System.out.println("mid2="+((r+l)/2+1));
            if(nums[mid]<=target){
                l=mid+1;
                rightBorder=l;
            }else{
                r=mid-1;
            }
        }

        if(leftBorder==-2||rightBorder==-2){
            return new  int [] {-1,-1};
        }

        if(rightBorder-leftBorder>1){
            return new int []{leftBorder+1,rightBorder-1};

        }else{
            return new  int [] {-1,-1};
        }

    }

}
